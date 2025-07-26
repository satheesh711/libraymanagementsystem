package com.libraryManagementSystem.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryManagementSystem.dao.MemberDao;
import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.utilities.MemberGender;
import com.libraryManagementSystem.utilities.PreparedStatementManager;
import com.libraryManagementSystem.utilities.SQLQueries;

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
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MemberGender gender = rs.getString("gender").equalsIgnoreCase("F") ? MemberGender.FEMALE
						: MemberGender.MALE;
				Member member = new Member(rs.getInt("member_id"), rs.getString("name"), rs.getString("email"),
						rs.getInt("mobile"), gender, rs.getString("address"));
				members.add(member);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving all members: " + e.getMessage());
		}

		return members;
	}

	@Override
	public void deleteMember(Member memberData) throws InvalidException {

		try {
			PreparedStatement stmt = PreparedStatementManager.getPreparedStatement(SQLQueries.MEMBER_DELETE);
			stmt.setInt(1, memberData.getMemberId());

			PreparedStatement stmt1 = PreparedStatementManager.getPreparedStatement(SQLQueries.MEMBERS_LOG_INSERT);

			stmt1.setInt(1, memberData.getMemberId());
			stmt1.setString(2, memberData.getName());
			stmt1.setString(3, memberData.getEmail());
			stmt1.setLong(4, memberData.getMobile());
			stmt1.setString(5, String.valueOf(memberData.getGender().toString().charAt(0)));
			stmt1.setString(6, memberData.getAddress());

			int rowsDeleted = stmt.executeUpdate();
			int rowsInserted = stmt1.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("log added ");
			}

			if (rowsDeleted <= 0) {

				throw new InvalidException("No Book found with Title: " + memberData.getName());
			}

		} catch (SQLException e) {
			throw new InvalidException("Error in Server" + e.getMessage());
		}

	}

}
