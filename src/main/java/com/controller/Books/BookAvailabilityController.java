package com.controller.Books;

import java.io.IOException;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class BookAvailabilityController {
	@FXML
	private void switchToBookOptions() throws Exception {
		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
}
