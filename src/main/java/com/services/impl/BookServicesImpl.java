package com.services.impl;

import java.util.List;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.domain.Book;
import com.services.BookServices;
import com.utilities.BookAvailability;
import com.utilities.Validations;
import com.validationException.InvalidException;

public class BookServicesImpl implements BookServices {

	private final BookDao bookDao = new BookDaoImpl();

	@Override
	public void addBook(Book book) throws InvalidException {

		if (!Validations.isValidString(book.getTitle())) {
			throw new InvalidException("Enter Valid Title");
		}

		if (!Validations.isValidString(book.getAuthor())) {
			throw new InvalidException("Enter valid Author Name");
		}

		if (book.getCategory() == null) {
			throw new InvalidException("Please Select Category Field!");
		}

		if (book.getStatus() == null) {
			throw new InvalidException("Please Select Status Field!");
		}

		if (book.getAvailability() == null) {
			throw new InvalidException("Please Select Availability Field!");
		}

		if (bookDao.getBookByTitleAndAuthor(book.getTitle(), book.getAuthor())) {

			throw new InvalidException("Book Already Exit");
		}

		bookDao.addBook(book);

	}

	@Override
	public List<Book> getBooks() {

		return bookDao.getAllBooks();

	}

	@Override
	public void deleteBook(Book book) throws InvalidException {

		bookDao.deleteBook(book);
	}

	@Override
	public void updateBook(Book book) throws InvalidException {

		if (!Validations.isValidString(book.getTitle())) {
			throw new InvalidException("Enter Valid Title");
		}

		if (!Validations.isValidString(book.getAuthor())) {
			throw new InvalidException("Enter valid Author Name");
		}

		if (book.getCategory() == null) {
			throw new InvalidException("Please Select Category Field!");
		}

		if (book.getStatus() == null) {
			throw new InvalidException("Please Select Status Field!");
		}

		if (book.getAvailability() == null) {
			throw new InvalidException("Please Select Availability Field!");
		}

		bookDao.updateBook(book);
	}

	@Override
	public void updateBookAvailability(Book book, BookAvailability avail) throws InvalidException {

		bookDao.updateBookAvalability(book, avail);

	}

}
