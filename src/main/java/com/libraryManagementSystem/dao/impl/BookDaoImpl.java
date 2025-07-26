package com.libraryManagementSystem.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryManagementSystem.dao.BookDao;
import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.utilities.BookAvailability;
import com.libraryManagementSystem.utilities.BookCategory;
import com.libraryManagementSystem.utilities.BookStatus;
import com.libraryManagementSystem.utilities.PreparedStatementManager;
import com.libraryManagementSystem.utilities.SQLQueries;

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
	public void updateBook(Book book, Book oldBook) throws InvalidException {

		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_UPDATE);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCategory().toString());
			stmt.setString(4, String.valueOf(book.getStatus().toString().charAt(0)));
			stmt.setString(5, String.valueOf(book.getAvailability().toString().charAt(0)));
			stmt.setInt(6, book.getBookId());

			bookLog(oldBook);

			int rowsUpdated = stmt.executeUpdate();

			if (rowsUpdated < 0) {
				throw new InvalidException("Book not added to server");
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw new InvalidException("Error in Server" + e.getMessage());
		}
	}

	@Override
	public void updateBookAvalability(Book book, BookAvailability avalability) throws InvalidException {
		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOK_UPDATE_AVAILABILITY);

			stmt.setString(1, String.valueOf(avalability.toString().charAt(0)));
			stmt.setInt(2, book.getBookId());

			int rowsUpdated = stmt.executeUpdate();
			bookLog(book);

			if (rowsUpdated > 0) {
				System.out.println("Book Avalability updated successfully.");
			} else {
				System.out.println("No Book found with ID: " + book.getBookId());
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw new InvalidException("Error in Server" + e.getMessage());
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

			int rowsDeleted = stmt.executeUpdate();

			bookLog(book);

			if (rowsDeleted <= 0) {

				throw new InvalidException("No Book found with Title: " + book.getTitle());
			}
		} catch (SQLException e) {
			throw new InvalidException("Error in Server" + e.getMessage());
		}

	}

	@Override
	public void bookLog(Book book) throws InvalidException {
		PreparedStatement stmt;
		try {

			stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.BOOKS_LOG_INSERT);
			stmt.setInt(1, book.getBookId());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getCategory().toString());
			stmt.setString(5, String.valueOf(book.getStatus().toString().charAt(0)));
			stmt.setString(6, String.valueOf(book.getAvailability().toString().charAt(0)));
			int rowsInserted = stmt.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("log added ");
			}

		} catch (SQLException e) {

			throw new InvalidException("Error in Server" + e.getMessage());
		}

	}

}
