package com.controller.Members;

import java.io.IOException;

import com.libraryManagementSystem.App;

public class MemberController {

	public void switchToBack() throws Exception {
		App.setRoot("primary");
	}

	public void registerMember() throws Exception {
		App.setRoot("RegisterMember");
	}

	public void SwitchToUpdateMember() throws IOException {
		App.setRoot("UpdateMember");
	}
}
