package com.libraryManagementSystem.utilities;

public class SQLQueries {

	private SQLQueries() {

	}

	public static final String MEMBER_INSERT = "INSERT INTO members (name, email, mobile, gender, address) VALUES (?, ?, ?,?,?)";

	public static final String MEMBER_UPDATE = "UPDATE members SET name = ? ,email = ?, mobile = ?, gender = ?, address =? WHERE member_id=?";

	public static final String SELECT_ALL_MEMBERS = "SELECT * FROM members";

	public static final String MEMBER_DELETE = "DELETE FROM members WHERE member_id= ?";

	public static final String MEMBER_SELECT_BY_MOBILE = "SELECT * FROM members WHERE mobile = ?";

	public static final String MEMBER_SELECT_BY_EMAIL = "SELECT * FROM members WHERE email = ?";

	// book

	public static final String BOOK_INSERT = "INSERT INTO books (title, author, category, status, availability) VALUES (?, ?, ?, ?, ?)";

	public static final String BOOK_UPDATE = "UPDATE books SET  title = ?, author = ?, category = ?, status = ?, availability = ? WHERE book_id = ?";

	public static final String BOOK_UPDATE_AVAILABILITY = "UPDATE books SET availability = ? WHERE book_id = ?";

	public static final String BOOK_SELECT_BY_TITLE_AUTHOR = "SELECT * FROM books WHERE LOWER(title) = LOWER(?) AND LOWER(author) = LOWER(?)";

	public static final String BOOK_SELECT_ALL = "SELECT * FROM books";

	public static final String BOOK_SELECT_BY_ID = "SELECT * FROM books WHERE book_id = ?";

	public static final String BOOK_DELETE = "DELETE FROM books WHERE book_id = ? ";

	// issue

	public static final String ISSUE_INSERT = "INSERT INTO issue_records (book_id, member_id, status, issue_date) VALUES (?, ?, ?, ?)";

	public static final String ISSUE_UPDATE_RETURN_DATE = "UPDATE issue_records  SET return_date = ? And status = 'R'  where issue_id = ?";

	public static final String ISSUE_SELECT_RETURN_DATE = "SELECT * FROM issue_records WHERE book_id = ? AND member_id = ? AND status = 'I' ";

	// Log Tables SQLQueries
	public static final String BOOKS_LOG_INSERT = "INSERT INTO books_log (book_id,title, author, category, status, availability) VALUES (?,?, ?, ?, ?, ?)";

	public static final String MEMBERS_LOG_INSERT = "INSERT INTO members_log (member_id,name,email,mobile,gender,address) VALUES(?,?,?,?,?,?)";

	public static final String ISSUE_LOG_INSERT = "INSERT INTO issue_records_log (issue_id,book_id, member_id, status, issue_date,return_date) VALUES (?, ?, ?, ?,?,?)";

}
