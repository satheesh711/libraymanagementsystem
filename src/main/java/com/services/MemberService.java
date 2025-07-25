package com.services;

import com.domain.Member;
import com.validationException.InvalidException;

public interface MemberService {

	void registerMember(Member member) throws InvalidException;

}
