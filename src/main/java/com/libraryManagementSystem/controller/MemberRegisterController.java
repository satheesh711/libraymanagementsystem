package com.libraryManagementSystem.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.libraryManagementSystem.App;
import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.services.MemberService;
import com.libraryManagementSystem.services.impl.MemberServiceImpl;
import com.libraryManagementSystem.utilities.MemberGender;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MemberRegisterController implements Initializable {

	MemberService memberService = new MemberServiceImpl();

	@FXML
	private ComboBox<MemberGender> gender;

	@FXML
	private TextField name;

	@FXML
	private TextField email;

	@FXML
	private TextField mobile;

	@FXML
	private TextField adress;

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

	@FXML
	public void submitDetails() {

		String memberName = name.getText();
		String memberEmail = email.getText();
		long memberMobile = 0L;
		MemberGender memberGender = gender.getSelectionModel().getSelectedItem();
		String memberAdress = adress.getText();
//		System.out.println(memberName + memberEmail + memberMobile + memberGender + memberAdress);
		Member newMember = new Member(-1, memberName, memberEmail, memberMobile, memberGender, memberAdress);

		try {
			memberService.registerMember(newMember);
			System.out.println("Member Registration successful!");
		} catch (InvalidException e) {
			System.out.println(e);
		}
	}

}
