package com.services.impl;

import com.domain.Member;
import com.services.MemberService;
import com.utilities.Validations;
import com.validationException.InvalidException;

public class MemberServiceImpl implements MemberService {

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

}
