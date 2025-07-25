package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.utilities.BookAvailability;

public interface BookServices {

	void addBook(Book book) throws InvalidException;

	List<Book> getBooks();

	void deleteBook(Book book) throws InvalidException;

	void updateBook(Book newBook, Book oldBook) throws InvalidException;

	void updateBookAvailability(Book book, BookAvailability avail) throws InvalidException;

}
