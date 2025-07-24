package com.controller.Books;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.libraryManagementSystem.App;
import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class BookAddController implements Initializable {

	@FXML
	private ComboBox<BookCategory> category;

	@FXML
	private ComboBox<BookStatus> status;

	@FXML
	private ComboBox<BookAvailability> availability;

	@FXML
	private void switchToBack() throws IOException {

		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToHome() throws IOException {

		App.setRoot("primary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		category.getItems().addAll(BookCategory.values());
		status.getItems().addAll(BookStatus.values());
		availability.getItems().addAll(BookAvailability.values());

	}

}
