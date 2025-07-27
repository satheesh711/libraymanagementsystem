package com.libraryManagementSystem.dao;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;

public interface MemberDao {

	void RegisterMember(Member member) throws InvalidException;

	void UpdateMember(Member newMember, Member oldMember) throws InvalidException;

	List<Member> getAllMembers() throws InvalidException;

	public void memberLog(Member member) throws InvalidException;

	void deleteMember(Member memberData) throws InvalidException;

	boolean getMemberByMobile(Long mobile) throws InvalidException;

	boolean getMemberByEmail(String email) throws InvalidException;

}
