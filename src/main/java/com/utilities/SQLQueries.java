package com.utilities;

public class SQLQueries {

	private void SQLQueries() {

	}

	public static final String MEMBER_INSERT = "INSERT INTO members (name, email, mobile, gender, address) VALUES (?, ?, ?,?,?)";

	public static final String MEMBER_UPDATE = "UPDATE members SET name = ?, email = ?, mobile = ?, gender = ?, address =? WHERE mobile=?";

	public static final String SELECT_ALL_MEMBERS = "SELECT * FROM members";

	public static final String BOOK_INSERT = "INSERT INTO books (title, author, category, status, availability) VALUES (?, ?, ?, ?, ?)";

	public static final String BOOK_UPDATE = "UPDATE books SET  title = ?, authour = ?, category = ?, status = ?, availability = ? WHERE book_id = ?";

	public static final String BOOK_UPDATE_AVAILABILITY = "UPDATE books SET availability = ? WHERE book_id = ?";

	public static final String BOOK_SELECT_ALL = "SELECT * FROM books";

	public static final String ISSUE_INSERT = "INSERT INTO issue_records (book_id, member_id, status, issue_date, return_date VALUES (?, ?, ?, ?, ?)";

	public static final String ISSUE_UPDATE_RETURN_DATE = "UPDATE issue_records SET return_date = ? WHERE book_id = ?";

}
