package com.dao;

import java.util.List;

import com.domain.Book;
import com.utilities.BookAvailability;
import com.validationException.InvalidException;

public interface BookDao {

	void addBook(Book book) throws InvalidException;

	void updateBook(Book book) throws InvalidException;

	void updateBookAvalability(Book book, BookAvailability avalability) throws InvalidException;

	boolean getBookByTitleAndAuthor(String title, String author) throws InvalidException;

	List<Book> getAllBooks();

	void deleteBook(Book book) throws InvalidException;

}
