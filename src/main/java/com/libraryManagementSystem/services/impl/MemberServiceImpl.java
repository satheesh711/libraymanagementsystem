package com.libraryManagementSystem.services.impl;

import java.util.List;

import com.libraryManagementSystem.dao.MemberDao;
import com.libraryManagementSystem.dao.impl.MemberDaoImpl;
import com.libraryManagementSystem.domain.Member;
import com.libraryManagementSystem.exceptions.InvalidException;
import com.libraryManagementSystem.services.MemberService;
import com.libraryManagementSystem.utilities.Validations;

public class MemberServiceImpl implements MemberService {

	private final MemberDao memberDao = new MemberDaoImpl();

	@Override
	public void registerMember(Member member) throws InvalidException {
		if (!Validations.isValidString(member.getName())) {
			throw new InvalidException("please enter valid name");
		}
		if (!Validations.isValidEmail(member.getEmail())) {
			throw new InvalidException("please enter valid email");
		}
		if (!Validations.isValidMobile(member.getMobile())) {
			throw new InvalidException("please enter valid mobileNumber");
		}
		if (member.getGender() == null) {
			throw new InvalidException("please select gender");
		}
		if (!Validations.isValidAdress(member.getAddress())) {
			throw new InvalidException("please enter valid adress");
		}

	}

	@Override
	public List<Member> getMembers() {

		return memberDao.getAllMembers();
	}

	@Override
	public void deleteMember(Member memberData) throws InvalidException {
		memberDao.deleteMember(memberData);

	}

}
