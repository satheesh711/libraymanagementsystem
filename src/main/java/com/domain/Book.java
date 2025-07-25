package com.domain;

import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private BookCategory category;
	private BookStatus status;
	private BookAvailability availability;

	public Book(int bookId, String title, String author, BookCategory category, BookStatus status,
			BookAvailability availability) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
		this.availability = availability;
	}

	public Book(String title, String author, BookCategory category, BookStatus status, BookAvailability availability) {
		this(-1, title, author, category, status, availability);
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

	public BookStatus getStatus() {
		return status;
	}

	public BookAvailability getAvailability() {
		return availability;
	}

	@Override
	public String toString() {

		return title;

	}

}
