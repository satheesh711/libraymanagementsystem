package com.libraryManagementSystem.dao;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;

public interface MemberDao {

	void RegisterMember(Member member);

	void UpdateMember(Member member);

	List<Member> getAllMembers();

	void deleteMember(Member memberData) throws InvalidException;

}
