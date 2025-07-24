package com.dao;

import java.util.List;

import com.domain.Book;

public interface BookDao {

	void addBook(Book book);

	void updateBook(Book book);

	void updateBookAvalability(int id, String avalability);

	List<Book> getAllBooks();

}
