package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.IssueRecordDao;
import com.utilities.PreparedStatementManager;
import com.utilities.SQLQueries;

public class IssueRecordDaoImpl implements IssueRecordDao {

	@Override
	public void issueBook(int memberId, int bookId) {
		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.ISSUE_INSERT);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void returnBook(int bookId) {

	}

}
