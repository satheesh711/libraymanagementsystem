package com.controller.Books;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class BookUpdateController {

	@FXML
	private void switchToBookOptions() throws Exception {
		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}
}
