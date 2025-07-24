package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dao.MemberDao;
import com.domain.Member;
import com.utilities.PreparedStatementManager;
import com.utilities.SQLQueries;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void RegisterMember(Member member) {
		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.MEMBER_INSERT);

			stmt.setInt(1, member.getMemberId());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getEmail());
			stmt.setInt(4, member.getMobile());
			stmt.setString(5, member.getGender());
			stmt.setString(6, member.getAddress());

			int rows = stmt.executeUpdate();

			if (rows > 0) {
				System.out.println("Member added successfully.");
			}

		} catch (SQLException e) {
			System.out.println("Error adding member: " + e.getMessage());
		}

	}

	@Override
	public void UpdateMember(Member member) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

}
