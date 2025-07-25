package com.services;

import com.domain.Book;
import com.validationException.InvalidException;

public interface BookServices {

	void addBook(Book book) throws InvalidException;
}
