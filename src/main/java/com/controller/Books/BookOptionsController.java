package com.controller.Books;

import java.io.IOException;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class BookOptionsController {

	@FXML
	private void switchToBack() throws IOException {

		App.setRoot("primary");
	}

	@FXML
	private void switchToAddBook() throws IOException {

		App.setRoot("AddBook");
	}

	@FXML
	private void switchToViewAllBooks() throws IOException {

		App.setRoot("ViewAllBooks");
	}
}