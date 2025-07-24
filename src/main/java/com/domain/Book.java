package com.domain;

import com.utilities.BookCategory;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private BookCategory category;
	private String status;
	private String availability;

	public Book(int bookId, String title, String author, BookCategory category, String status, String availability) {
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

	public BookCategory getCategory() {

		return category;
	}

	public String getStatus() {
		return status;
	}

	public String getAvailability() {
		return availability;
	}

	@Override
	public String toString() {

		return "bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category + ", status="
				+ status + ", availability=" + availability;

	}

}
