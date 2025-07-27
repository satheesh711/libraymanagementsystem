package com.libraryManagementSystem.controller;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class CountOfBooksController {
	@FXML
	public void switchTOReports() throws Exception {
		App.setRoot("Reports");
	}

	@FXML
	public void switchTOHome() throws Exception {
		App.setRoot("primary");
	}
}
