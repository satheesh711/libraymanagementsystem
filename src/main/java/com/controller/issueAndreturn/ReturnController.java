package com.controller.issueAndreturn;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class ReturnController {

	@FXML
	public void switchToIssueAndReturn() throws Exception {
		App.setRoot("Issue&Return");
	}

	@FXML
	public void switchTOPrimary() throws Exception {
		App.setRoot("primary");
	}
}
