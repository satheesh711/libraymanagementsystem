package com.libraryManagementSystem.domain;

import java.time.LocalDate;

public class CustomActiveIssuedBooks {
	private int memberId;
	private String memberName;
	private int bookId;
	private String booTitle;
	private LocalDate issueDate;

	public CustomActiveIssuedBooks(int memberId, String memberName, int bookId, String booTitle, LocalDate issueDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.bookId = bookId;
		this.booTitle = booTitle;
		this.issueDate = issueDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBooTitle() {
		return booTitle;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

}
