package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;

public interface MemberService {

	void registerMember(Member member) throws InvalidException;

	List<Member> getMembers() throws InvalidException;

	void updateMember(Member newMember, Member oldMember) throws InvalidException;

	void deleteMember(Member memberData) throws InvalidException;
}
