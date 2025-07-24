package com.domain;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private String category;
	private char status;
	private char availability;

	public Book(int bookId, String title, String author, String category, char status, char availability) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
		this.availability = availability;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public char getStatus() {
		return status;
	}

	public char getAvailability() {
		return availability;
	}

	@Override
	public String toString() {

		return "bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category + ", status="
				+ status + ", availability=" + availability;

	}

}
