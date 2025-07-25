package com.controller.Books;

import com.libraryManagementSystem.App;
import com.services.BookServices;
import com.services.impl.BookServicesImpl;
import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookUpdateController {

	BookServices bookService = new BookServicesImpl();

	@FXML
	private ComboBox<BookCategory> category;
	@FXML
	private ComboBox<BookStatus> status;
	@FXML
	private ComboBox<BookAvailability> availability;
	@FXML
	private TextField title;
	@FXML
	private TextField author;
	@FXML
	private Label error;

	@FXML
	private void switchToBookOptions() throws Exception {
		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}

}
