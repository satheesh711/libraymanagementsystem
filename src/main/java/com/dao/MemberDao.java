package com.dao;

import java.util.List;

import com.domain.Member;
import com.validationException.InvalidException;

public interface MemberDao {

	void RegisterMember(Member member);

	void UpdateMember(Member member);

	List<Member> getAllMembers();

	void deleteMember(Member memberData) throws InvalidException;

}
