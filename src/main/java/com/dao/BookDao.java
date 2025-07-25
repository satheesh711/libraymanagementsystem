package com.dao;

import java.util.List;

import com.domain.Book;
import com.validationException.InvalidException;

public interface BookDao {

	void addBook(Book book) throws InvalidException;

	void updateBook(Book book);

	void updateBookAvalability(int id, String avalability);

	boolean getBookByTitleAndAuthor(String title, String author) throws InvalidException;

	List<Book> getAllBooks();

	void deleteBook(Book book) throws InvalidException;

}
