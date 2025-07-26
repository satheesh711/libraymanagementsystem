package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;

public interface MemberService {

	void registerMember(Member member) throws InvalidException;

	List<Member> getMembers();

	void deleteMember(Member memberData) throws InvalidException;
}
