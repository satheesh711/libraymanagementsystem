package com.libraryManagementSystem.domain;

import java.util.Date;

public class CustomOverDueBooks {

	private int bookId;
	private int memberId;
	private String memberName;
	private Date issuedate;
	private Date returnDate;

	public CustomOverDueBooks(int bookId, int memberId, String memberName, Date issuedate, Date returnDate) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.issuedate = issuedate;
		this.returnDate = returnDate;
	}

	public int getBookId() {
		return bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

}
