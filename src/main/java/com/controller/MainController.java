package com.controller;

import java.io.IOException;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class MainController {

	@FXML
	public void switchToBook() throws IOException {

		App.setRoot("BookOptions");
	}
}
