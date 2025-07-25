package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BookDao;
import com.domain.Book;
import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;
import com.utilities.PreparedStatementManager;
import com.utilities.SQLQueries;
import com.validationException.InvalidException;

public class BookDaoImpl implements BookDao {

	@Override
	public void addBook(Book book) throws InvalidException {

		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_INSERT);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCategory().toString());
			stmt.setString(4, String.valueOf(book.getStatus().toString().charAt(0)));
			stmt.setString(5, String.valueOf(book.getAvailability().toString().charAt(0)));

			int rows = stmt.executeUpdate();

			if (rows < 0) {
				throw new InvalidException("Book not added to server");
			}

		} catch (SQLException e) {
			throw new InvalidException("Error in Server");
		}

	}

	@Override
	public void updateBook(Book book) {

		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_UPDATE);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCategory().toString());
			stmt.setString(4, book.getStatus().toString());
			stmt.setString(5, book.getAvailability().toString());
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
				BookStatus status = rs.getString("status").equals("A") ? BookStatus.ACTIVE : BookStatus.INACTIVE;
				BookAvailability availability = rs.getString("availability").equalsIgnoreCase("A")
						? BookAvailability.AVAILABLE
						: BookAvailability.ISSUED;
				Book book = new Book(bookId, title, author, BookCategory.valueOf(category.toUpperCase()), status,
						availability);
				books.add(book);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving all members: " + e.getMessage());
		}

		return books;
	}

	@Override
	public boolean getBookByTitleAndAuthor(String title, String author) throws InvalidException {
		PreparedStatement stmt;
		try {

			stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_SELECT_BY_TITLE_AUTHOR);
			stmt.setString(1, title.trim().toLowerCase());
			stmt.setString(2, author.trim().toLowerCase());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				return true;
			}

			return false;

		} catch (SQLException e) {
			throw new InvalidException("Error in Server" + e.getMessage());
		}

	}

	@Override
	public void deleteBook(Book book) throws InvalidException {

		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_DELETE);
			stmt.setInt(1, book.getBookId());

			PreparedStatement stmt1 = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOKS_LOG_INSERT);

			stmt1.setInt(1, book.getBookId());
			stmt1.setString(2, book.getTitle());
			stmt1.setString(3, book.getAuthor());
			stmt1.setString(4, book.getCategory().toString());
			stmt1.setString(5, String.valueOf(book.getStatus().toString().charAt(0)));
			stmt1.setString(6, String.valueOf(book.getAvailability().toString().charAt(0)));

			int rowsDeleted = stmt.executeUpdate();
			int rowsInserted = stmt1.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("log added ");
			}

			if (rowsDeleted <= 0) {

				throw new InvalidException("No Book found with Title: " + book.getTitle());
			}
		} catch (SQLException e) {
			throw new InvalidException("Error in Server" + e.getMessage());
		}

	}

}
