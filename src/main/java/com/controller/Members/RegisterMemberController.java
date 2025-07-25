package com.controller.Members;

import java.net.URL;
import java.util.ResourceBundle;

import com.libraryManagementSystem.App;
import com.utilities.MemberGender;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class RegisterMemberController implements Initializable {

	@FXML
	private ComboBox<MemberGender> gender;

	public void switchToMembers() throws Exception {
		App.setRoot("Members");
	}

	public void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		gender.getItems().addAll(MemberGender.values());
	}

}
