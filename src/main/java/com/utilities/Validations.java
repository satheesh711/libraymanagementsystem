package com.utilities;

public class Validations {

	public static boolean isValidString(String name) {

		return name.matches("^[A-Z a-z]{2,50}$");
	}

}
