package com.libraryManagementSystem.controller;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class BooksOverDueController {
	@FXML
	public void switchTOReports() throws Exception {
		App.setRoot("Reports");
	}

	public void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}
}
