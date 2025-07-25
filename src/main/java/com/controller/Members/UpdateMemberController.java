package com.controller.Members;

import java.io.IOException;

import com.libraryManagementSystem.App;

import javafx.fxml.FXML;

public class UpdateMemberController {

	@FXML
	private void switchToMembers() throws Exception {
		App.setRoot("Members");
	}

	@FXML
	private void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
}
