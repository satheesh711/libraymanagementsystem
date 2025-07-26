package com.libraryManagementSystem.dao;

public interface IssueRecordDao {

	void issueBook(int memberId, int bookId);

	void returnBook(int bookId);
}
