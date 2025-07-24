package com.dao;

import java.util.List;

import com.domain.Member;

public interface MemberDao {

	void RegisterMember(Member member);

	void UpdateMember(Member member);

	List<Member> getAllMembers();

}
