package com.services;

import java.util.List;

import com.domain.Book;
import com.utilities.BookAvailability;
import com.validationException.InvalidException;

public interface BookServices {

	void addBook(Book book) throws InvalidException;

	List<Book> getBooks();

	void deleteBook(Book book) throws InvalidException;

	void updateBook(Book book) throws InvalidException;

	void updateBookAvailability(Book book, BookAvailability avail) throws InvalidException;

}
