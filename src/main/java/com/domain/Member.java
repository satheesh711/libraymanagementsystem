package com.domain;

public class Member {
	private int memberId;
	private String name;
	private String email;
	private int mobile;
	private String gender;
	private String address;

	public Member(int memberId, String name, String email, int mobile, String gender, String address) {
		super();
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

	public int getMobile() {
		return mobile;
	}

	public String getGender() {
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
