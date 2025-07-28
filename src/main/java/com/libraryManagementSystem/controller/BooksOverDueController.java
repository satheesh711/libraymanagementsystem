package com.libraryManagementSystem.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.libraryManagementSystem.App;
import com.libraryManagementSystem.domain.Book;
import com.libraryManagementSystem.domain.IssueRecord;
import com.libraryManagementSystem.domain.Member;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BooksOverDueController implements Initializable {

	@FXML
	private TableView<Book> bookTableView;
	@FXML
	private TableColumn<Book, Integer> bookId;
	@FXML
	private TableColumn<Member, Integer> memberId;
	@FXML
	private TableColumn<Member, String> memberName;
	@FXML
	private TableColumn<IssueRecord, LocalDate> issueDate;
	@FXML
	private TableColumn<IssueRecord, LocalDate> returnDate;

	@FXML
	public void switchTOReports() throws Exception {
		App.setRoot("Reports");
	}

	public void switchToPrimary() throws Exception {
		App.setRoot("primary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
