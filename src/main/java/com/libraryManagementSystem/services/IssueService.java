package com.libraryManagementSystem.services;

import java.time.LocalDate;

import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.domain.IssueRecord;
import com.libraryManagementSystem.exceptions.BookNotFoundException;
import com.libraryManagementSystem.exceptions.DatabaseOperationException;
import com.libraryManagementSystem.exceptions.InvalidIssueDataException;

public interface IssueService {

	void addIssue(IssueRecord newIssue)
			throws DatabaseOperationException, InvalidIssueDataException, BookNotFoundException;

	void returnBook(Book book, int id, LocalDate date)
			throws DatabaseOperationException, InvalidIssueDataException, BookNotFoundException;
}
