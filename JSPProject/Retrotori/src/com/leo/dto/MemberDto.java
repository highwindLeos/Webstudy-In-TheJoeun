package com.leo.dto;

import java.sql.Timestamp;

public class MemberDto {
	private String mId;
	private String mPw;
	private String mName;
	private String mEmail;
	private String mPhoto;
	private String mTel;
	private String mGender;
	private String mAddr;
	private String mText;
	private Timestamp mBirth;
	private Timestamp mRdate;
	private int mPoint;
	
	public MemberDto() {}

	public MemberDto(String mId, String mPw, String mName, String mEmail, String mPhoto, String mTel, String mGender,
			String mAddr, String mText, Timestamp mBirth, Timestamp mRdate, int mPoint) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhoto = mPhoto;
		this.mTel = mTel;
		this.mGender = mGender;
		this.mAddr = mAddr;
		this.mText = mText;
		this.mBirth = mBirth;
		this.mRdate = mRdate;
		this.mPoint = mPoint;
	}
	
	@Override
	public String toString() {
		return "멤버 정보 [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mEmail=" + mEmail + ", mPhoto="
				+ mPhoto + ", mTel=" + mTel + ", mGender=" + mGender + ", mAddr=" + mAddr + ", mText=" + mText
				+ ", mBirth=" + mBirth + ", mRdate=" + mRdate + ", mPoint=" + mPoint + "]";
	}
	
	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhoto() {
		return mPhoto;
	}

	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmGender() {
		return mGender;
	}

	public void setmGender(String mGender) {
		this.mGender = mGender;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public String getmText() {
		return mText;
	}

	public void setmText(String mText) {
		this.mText = mText;
	}

	public Timestamp getmBirth() {
		return mBirth;
	}

	public void setmBirth(Timestamp mBirth) {
		this.mBirth = mBirth;
	}

	public Timestamp getmRdate() {
		return mRdate;
	}

	public void setmRdate(Timestamp mRdate) {
		this.mRdate = mRdate;
	}

	public int getmPoint() {
		return mPoint;
	}

	public void setmPoint(int mPoint) {
		this.mPoint = mPoint;
	}
	
}
