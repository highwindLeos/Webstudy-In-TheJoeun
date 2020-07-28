package com.leo.dto;

import java.sql.Date;

public class GameDto {

	private String gIdTag;
	private String gId;
	private String gName;
	private String gImage;
	private String gDes;
	private String gPub;
	private Date gRdate;
	private int gGrade;
	private int gVoteCnt;
	private int gGno;
	private String gRname;
	private int lowPoint;
	private int hiPoint;
	private Double gradeAvg;
	
	public GameDto() { }

	
	public GameDto(String gIdTag, String gId, String gName, String gImage, String gDes, String gPub, Date gRdate) {
		this.gIdTag = gIdTag;
		this.gId = gId;
		this.gName = gName;
		this.gImage = gImage;
		this.gDes = gDes;
		this.gPub = gPub;
		this.gRdate = gRdate;
	}

	public GameDto(String gId, String gName, String gImage, String gDes, String gPub, Date gRdate, int gGrade,
			int gVoteCnt, int gGno, String gRname, int lowPoint, int hiPoint) {
		this.gId = gId;
		this.gName = gName;
		this.gImage = gImage;
		this.gDes = gDes;
		this.gPub = gPub;
		this.gRdate = gRdate;
		this.gGrade = gGrade;
		this.gVoteCnt = gVoteCnt;
		this.gGno = gGno;
		this.gRname = gRname;
		this.lowPoint = lowPoint;
		this.hiPoint = hiPoint;
	}

	
	
	public GameDto(String gId, String gName, String gImage, String gDes, String gPub, Date gRdate, int gGrade,
			int gVoteCnt, int gGno, String gRname, int lowPoint, int hiPoint, Double gradeAvg) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gImage = gImage;
		this.gDes = gDes;
		this.gPub = gPub;
		this.gRdate = gRdate;
		this.gGrade = gGrade;
		this.gVoteCnt = gVoteCnt;
		this.gGno = gGno;
		this.gRname = gRname;
		this.lowPoint = lowPoint;
		this.hiPoint = hiPoint;
		this.gradeAvg = gradeAvg;
	}
	
	
	
	@Override
	public String toString() {
		return "게임정보 [gIdTag=" + gIdTag + ", gId=" + gId + ", gName=" + gName + ", gImage=" + gImage + ", gDes="
				+ gDes + ", gPub=" + gPub + ", gRdate=" + gRdate + ", gGrade=" + gGrade + ", gVoteCnt=" + gVoteCnt
				+ ", gGno=" + gGno + ", gRname=" + gRname + ", lowPoint=" + lowPoint + ", hiPoint=" + hiPoint
				+ ", gradeAvg=" + gradeAvg + "]";
	}


	public String getgIdTag() {
		return gIdTag;
	}


	public void setgIdTag(String gIdTag) {
		this.gIdTag = gIdTag;
	}


	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgImage() {
		return gImage;
	}

	public void setgImage(String gImage) {
		this.gImage = gImage;
	}

	public String getgDes() {
		return gDes;
	}

	public void setgDes(String gDes) {
		this.gDes = gDes;
	}

	public String getgPub() {
		return gPub;
	}

	public void setgPub(String gPub) {
		this.gPub = gPub;
	}

	public Date getgRdate() {
		return gRdate;
	}

	public void setgRdate(Date gRdate) {
		this.gRdate = gRdate;
	}

	public int getgGrade() {
		return gGrade;
	}

	public void setgGrade(int gGrade) {
		this.gGrade = gGrade;
	}

	public int getgVoteCnt() {
		return gVoteCnt;
	}

	public void setgVoteCnt(int gVoteCnt) {
		this.gVoteCnt = gVoteCnt;
	}

	public int getgGno() {
		return gGno;
	}

	public void setgGno(int gGno) {
		this.gGno = gGno;
	}

	public String getgRname() {
		return gRname;
	}

	public void setgRname(String gRname) {
		this.gRname = gRname;
	}

	public int getLowPoint() {
		return lowPoint;
	}

	public void setLowPoint(int lowPoint) {
		this.lowPoint = lowPoint;
	}

	public int getHiPoint() {
		return hiPoint;
	}

	public void setHiPoint(int hiPoint) {
		this.hiPoint = hiPoint;
	}

	public Double getGradeAvg() {
		return gradeAvg;
	}

	public void setGradeAvg(Double gradeAvg) {
		this.gradeAvg = gradeAvg;
	}	

}
