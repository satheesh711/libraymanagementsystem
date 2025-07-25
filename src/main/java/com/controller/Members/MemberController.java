package com.controller.Members;

import com.libraryManagementSystem.App;

public class MemberController {

	public void switchToBack() throws Exception {
		App.setRoot("primary");
	}

	public void registerMember() throws Exception {
		App.setRoot("RegisterMember");
	}
}
