package com.libraryManagementSystem.domain;

import com.libraryManagementSystem.utilities.MemberGender;

public class Member {
	private int memberId;
	private String name;
	private String email;
	private long mobile;
	private MemberGender gender;
	private String address;

	public Member(int memberId, String name, String email, long mobile, MemberGender gender, String address) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public long getMobile() {
		return mobile;
	}

	public MemberGender getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "memberId :" + memberId + ", name : " + name + ", email : " + email + ", mobile :" + mobile
				+ ", gender : " + gender + ", address : " + address;
	}

}
