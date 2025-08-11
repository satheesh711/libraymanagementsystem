package com.libraryManagementSystem.dao;

import java.time.LocalDate;

import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.domain.IssueRecord;
import com.libraryManagementSystem.exceptions.DatabaseConnectionException;
import com.libraryManagementSystem.exceptions.DatabaseOperationException;

public interface IssueRecordDao {

	void issueBook(IssueRecord newIssue, Book book) throws DatabaseOperationException, DatabaseConnectionException;

	void returnBook(Book book, int id, LocalDate date) throws DatabaseOperationException;

	void issueLog(IssueRecord issue) throws DatabaseOperationException;
}
