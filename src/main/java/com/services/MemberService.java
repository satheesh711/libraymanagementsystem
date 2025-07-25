package com.services;

import java.util.List;

import com.domain.Member;
import com.validationException.InvalidException;

public interface MemberService {

	void registerMember(Member member) throws InvalidException;

	List<Member> getMembers();

	void deleteMember(Member memberData) throws InvalidException;
}
