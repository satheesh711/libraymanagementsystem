package com.services.impl;

import com.domain.Book;
import com.services.BookServices;
import com.utilities.Validations;
import com.validationException.InvalidException;

public class BookServicesImpl implements BookServices {

	@Override
	public void addBook(Book book) throws InvalidException {

		if (!Validations.isValidString(book.getTitle())) {
			throw new InvalidException("Enter Valid Title");
		}

		if (!Validations.isValidString(book.getAuthor())) {
			throw new InvalidException("Enter valid Author Name");
		}

		if (book.getCategory() == null) {
			throw new InvalidException("Please Select Category Field!");
		}

		if (book.getStatus() == null) {
			throw new InvalidException("Please Select Status Field!");
		}

		if (book.getAvailability() == null) {
			throw new InvalidException("Please Select Availability Field!");
		}
	}

}
