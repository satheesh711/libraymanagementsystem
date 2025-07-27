package com.libraryManagementSystem.controller;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class ActiveBooksController {
	@FXML
	public void switchToReports() throws Exception {
		App.setRoot("Reports");
	}

	@FXML
	public void switchToHome() throws Exception {
		App.setRoot("primary");
	}
}
