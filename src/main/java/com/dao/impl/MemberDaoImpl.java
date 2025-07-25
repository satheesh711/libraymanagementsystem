package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
			stmt.setLong(4, member.getMobile());
			stmt.setString(5, member.getGender().toString());
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

		try {

			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.MEMBER_UPDATE);

			stmt.setInt(1, member.getMemberId());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getEmail());
			stmt.setLong(4, member.getMobile());
			stmt.setString(5, member.getGender().toString());
			stmt.setString(6, member.getAddress());

			int rowsUpdated = stmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Member updated successfully.");
			} else {
				System.out.println("No member found with ID: " + member.getMemberId());
			}

		} catch (SQLException e) {
			System.out.println("Error updating member: " + e.getMessage());
		}
	}

	@Override
	public List<Member> getAllMembers() {

		List<Member> members = new ArrayList<>();
		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.SELECT_ALL_MEMBERS);

//			ResultSet rs = stmt.executeQuery();

//			while (rs.next()) {
//				Member member = new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
//						rs.getInt("mobile"), rs.getString("gender"), rs.getString("adress"));
//				members.add(member);
//			}

		} catch (SQLException e) {
			System.out.println("Error retrieving all members: " + e.getMessage());
		}

		return members;
	}

}
