package com.libraryManagementSystem.controller;

import java.io.IOException;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class MemberUpdateController {

	@FXML
	private void switchToMembers() throws Exception {
		App.setRoot("Members");
	}

	@FXML
	private void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
}
