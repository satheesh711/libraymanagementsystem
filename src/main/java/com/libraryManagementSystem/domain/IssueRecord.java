package com.libraryManagementSystem.domain;

import java.time.LocalDate;

public class IssueRecord {

	private int issueId;
	private int bookId;
	private int memberId;
	private char status;
	private LocalDate issueDate;
	private LocalDate returnDate;

	public IssueRecord(int issueId, int bookId, int memberId, char status, LocalDate issueDate, LocalDate returnDate) {
		this.issueId = issueId;
		this.bookId = bookId;
		this.memberId = memberId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	public int getIssueId() {
		return issueId;
	}

	public int getBookId() {
		return bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public char getStatus() {
		return status;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	@Override
	public String toString() {

		return "issueId=" + issueId + ", bookId=" + bookId + ", memberId=" + memberId + ", status=" + status
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate;

	}

}
