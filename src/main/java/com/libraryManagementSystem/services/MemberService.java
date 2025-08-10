package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.DatabaseConnectionException;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.exceptions.StatementPreparationException;

public interface MemberService {

	int registerMember(Member member)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	List<Member> getMembers() throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	int updateMember(Member newMember, Member oldMember)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;

	int deleteMember(Member memberData)
			throws InvalidException, DatabaseConnectionException, StatementPreparationException;
}
