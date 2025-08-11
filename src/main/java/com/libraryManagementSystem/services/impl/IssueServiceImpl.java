package com.libraryManagementSystem.services.impl;

import java.time.LocalDate;

import com.libraryManagementSystem.dao.BookDao;
import com.libraryManagementSystem.dao.IssueRecordDao;
import com.libraryManagementSystem.dao.impl.BookDaoImpl;
import com.libraryManagementSystem.dao.impl.IssueRecordDaoImpl;
import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.domain.IssueRecord;
import com.libraryManagementSystem.exceptions.BookNotFoundException;
import com.libraryManagementSystem.exceptions.DatabaseConnectionException;
import com.libraryManagementSystem.exceptions.DatabaseOperationException;
import com.libraryManagementSystem.exceptions.InvalidIssueDataException;
import com.libraryManagementSystem.services.IssueService;
import com.libraryManagementSystem.utilities.BookAvailability;
import com.libraryManagementSystem.utilities.BookStatus;

public class IssueServiceImpl implements IssueService {

	private final BookDao bookDao = new BookDaoImpl();
	private final IssueRecordDao issueDao = new IssueRecordDaoImpl();

	@Override
	public void addIssue(IssueRecord newIssue)
			throws DatabaseOperationException, InvalidIssueDataException, BookNotFoundException {

		if (newIssue.getIssueDate().isAfter(LocalDate.now())) {
			throw new InvalidIssueDataException("Date Should not greater than today!");
		}

		Book book = null;
		try {
			book = bookDao.getBookById(newIssue.getBookId());
		} catch (DatabaseOperationException e) {

			throw new DatabaseOperationException(e.getMessage());
		}
		if (book == null) {
			throw new BookNotFoundException("Book Details not found");
		}

		if (!(book.getAvailability().equals(BookAvailability.AVAILABLE))) {
			throw new InvalidIssueDataException("Book Already Issued");
		}

		if (!(book.getStatus().equals(BookStatus.ACTIVE))) {
			throw new InvalidIssueDataException("Book Not Active");
		}

		try {
			issueDao.issueBook(newIssue, book);
		} catch (DatabaseOperationException | DatabaseConnectionException e) {
			throw new DatabaseOperationException(e.getMessage());
		}
	}

	@Override
	public void returnBook(Book book, int id, LocalDate date)
			throws DatabaseOperationException, InvalidIssueDataException, BookNotFoundException {

		if (date.isAfter(LocalDate.now())) {
			throw new InvalidIssueDataException("Date Should not greater than today!");
		}

		if (book == null) {
			throw new BookNotFoundException("Book Details not found");
		}

		if (!(book.getAvailability().equals(BookAvailability.ISSUED))) {
			throw new InvalidIssueDataException("Book Not Issued");
		}

		issueDao.returnBook(book, id, date);

	}

}
