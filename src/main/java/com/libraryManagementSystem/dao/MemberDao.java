package com.libraryManagementSystem.dao;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.DatabaseConnectionException;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.exceptions.StatementPreparationException;

public interface MemberDao {

	int RegisterMember(Member member)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	int UpdateMember(Member newMember, Member oldMember)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	List<Member> getAllMembers() throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	public void memberLog(Member member)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	int deleteMember(Member memberData)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	boolean getMemberByMobile(Long mobile)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	boolean getMemberByEmail(String email)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

}
