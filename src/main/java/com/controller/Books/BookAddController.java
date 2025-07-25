package com.controller.Books;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.domain.Book;
import com.libraryManagementSystem.App;
import com.services.BookServices;
import com.services.impl.BookServicesImpl;
import com.utilities.BookAvailability;
import com.utilities.BookCategory;
import com.utilities.BookStatus;
import com.validationException.InvalidException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BookAddController implements Initializable {

	BookServices bookService = new BookServicesImpl();

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
	private void switchToBack() throws IOException {

		App.setRoot("BookOptions");
	}

	@FXML
	private void switchToHome() throws IOException {

		App.setRoot("primary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		category.getItems().addAll(BookCategory.values());
		status.getItems().addAll(BookStatus.values());
		availability.getItems().addAll(BookAvailability.values());

	}

	@FXML
	public void submit() {

		String bookTitle = title.getText();
		String bookAuthor = author.getText();
		BookCategory bookcategory = category.getSelectionModel().getSelectedItem();
		BookStatus bookstatus = status.getSelectionModel().getSelectedItem();
		BookAvailability bookAvailability = availability.getSelectionModel().getSelectedItem();

		Book newBook = new Book(bookTitle, bookAuthor, bookcategory, bookstatus, bookAvailability);
		try {
			bookService.addBook(newBook);
			System.out.println("Book added Successfully");
		} catch (InvalidException e) {
			System.out.println(e);
		}

	}

}
