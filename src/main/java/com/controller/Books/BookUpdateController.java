package com.controller.Books;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.domain.Book;
import com.libraryManagementSystem.App;
import com.services.BookServices;
import com.services.impl.BookServicesImpl;
import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookUpdateController implements Initializable {

	BookServices bookService = new BookServicesImpl();

	@FXML
	private ComboBox<Book> books;
	@FXML
	private ComboBox<BookCategory> category;
	@FXML
	private ComboBox<BookStatus> status;
	@FXML
	private ComboBox<BookAvailability> availability;
	@FXML
	private TextField title;
	@FXML
	private TextField author;
	@FXML
	private Label error;

	@FXML
	private void switchToBookOptions() throws Exception {
		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Book> bookTitles = bookService.getBooks();
		books.getItems().addAll(bookTitles);
		books.setOnAction(event -> {
			if (!books.getSelectionModel().isEmpty()) {
				Book book = books.getSelectionModel().getSelectedItem();
				category.setDisable(false);
				category.getItems().addAll(BookCategory.values());
				category.getSelectionModel().select(book.getCategory());

			}
		});

//		status.getItems().addAll(BookStatus.values());
//		availability.getItems().addAll(BookAvailability.values());

	}

}
