package com.utilities;

public class SQLQueries {

	private void SQLQueries() {

	}

	public static final String MEMBER_INSERT = "INSERT INTO memberS (member_id,name ,email,mobile,gender,address) VALUES (?, ?, ?,?,?,?)";

	public static final String MEMBER_UPDATE = "UPDATE member SET member_id = ?, name = ?, email = ?,mobile = ?,gender = ?,address =?where mobile=?";

	public static final String SELECT_ALL_MEMBERS = "select * from members";
}
