package com.leo.dto;

public class FollowDto {
	private int fNum;
	private String mId;
	private String fId;
	private String mName;
	private String mPhoto;
	
	public FollowDto() {}

	public FollowDto(int fNum, String mId, String fId, String mName, String mPhoto) {
		this.fNum = fNum;
		this.mId = mId;
		this.fId = fId;
		this.mName = mName;
		this.mPhoto = mPhoto;
	}

	@Override
	public String toString() {
		return "팔로우 정보 [fNum=" + fNum + ", mId=" + mId + ", fId=" + fId + ", mName=" + mName + ", mPhoto=" + mPhoto
				+ "]";
	}

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
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

	
}
