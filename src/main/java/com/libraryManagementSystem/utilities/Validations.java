package com.libraryManagementSystem.utilities;

public class Validations {

	public static boolean isValidString(String name) {

		return name.matches("^[A-Z a-z]{2,255}$");
	}

	public static boolean isValidMobile(long mobile) {

		return String.valueOf(mobile).matches("^[0-9]{9}$");

	}

	public static boolean isValidEmail(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}

	public static boolean isValidAdress(String adress) {
		return adress.matches("^[A-Za-z0-9\\\\s,./#-]{5,100}$");
	}

}
