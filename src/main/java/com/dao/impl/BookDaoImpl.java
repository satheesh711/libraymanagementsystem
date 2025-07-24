package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BookDao;
import com.domain.Book;
import com.utilities.BookCategory;
import com.utilities.PreparedStatementManager;
import com.utilities.SQLQueries;

public class BookDaoImpl implements BookDao {

	@Override
	public void addBook(Book book) {

		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_INSERT);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCategory().toString());
			stmt.setString(4, book.getStatus());
			stmt.setString(5, book.getAvailability());

			int rows = stmt.executeUpdate();

			if (rows > 0) {
				System.out.println("Book added successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBook(Book book) {

		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_UPDATE);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCategory().toString());
			stmt.setString(4, book.getStatus());
			stmt.setString(5, book.getAvailability());
			stmt.setInt(6, book.getBookId());

			int rowsUpdated = stmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Book updated successfully.");
			} else {
				System.out.println("No Book found with ID: " + book.getBookId());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateBookAvalability(int id, String avalability) {
		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_UPDATE_AVAILABILITY);

			stmt.setString(1, avalability);
			stmt.setInt(2, id);

			int rowsUpdated = stmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Book Avalability updated successfully.");
			} else {
				System.out.println("No Book found with ID: " + id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();

		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_SELECT_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String status = rs.getString("status");
				String availability = rs.getString("availability");

				Book book = new Book(bookId, title, author, BookCategory.valueOf(category.toUpperCase()), status,
						availability);

				books.add(book);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving all members: " + e.getMessage());
		}

		return books;
	}

}
