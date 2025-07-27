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

		if (memberDao.getMemberByMobile(member.getMobile())) {

			throw new InvalidException("Mobile Number Already Exit");
		}

		if (memberDao.getMemberByEmail(member.getEmail())) {

			throw new InvalidException("Email Already Exit");
		}

		memberDao.RegisterMember(member);

	}

	@Override
	public List<Member> getMembers() throws InvalidException {

		return memberDao.getAllMembers();
	}

	@Override
	public void deleteMember(Member memberData) throws InvalidException {
		memberDao.deleteMember(memberData);

	}

	@Override
	public void updateMember(Member newMember, Member oldMember) throws InvalidException {

		if (!Validations.isValidString(newMember.getName())) {
			throw new InvalidException("please enter valid name");
		}

		if (!Validations.isValidEmail(newMember.getEmail())) {
			throw new InvalidException("please enter valid email");
		}

		if (!Validations.isValidMobile(newMember.getMobile())) {
			throw new InvalidException("please enter valid mobileNumber");
		}

		if (newMember.getGender() == null) {
			throw new InvalidException("please select gender");
		}

		if (!Validations.isValidAdress(newMember.getAddress())) {
			throw new InvalidException("please enter valid adress");
		}

		memberDao.UpdateMember(newMember, oldMember);

	}

}
