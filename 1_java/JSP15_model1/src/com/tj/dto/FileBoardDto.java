package com.tj.dto;

import java.sql.Timestamp;

public class FileBoardDto {
	private int fnum;
	private String cid;
	private String cname;
	private String cemail;
	private String fsubject;
	private String fcontent;
	private String ffilename;
	private int freadcount;
	private String fpw;
	private int fref;
	private int frestep;
	private int frelevel;
	private String fip;
	private Timestamp frdate;
	
	public FileBoardDto() {	}

	
	
	public FileBoardDto(int fnum, String cid, String cname, String cemail, String fsubject, String fcontent,
			String ffilename, int freadcount, String fpw, int fref, int frestep, int frelevel, String fip,
			Timestamp frdate) {
		this.fnum = fnum;
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.freadcount = freadcount;
		this.fpw = fpw;
		this.fref = fref;
		this.frestep = frestep;
		this.frelevel = frelevel;
		this.fip = fip;
		this.frdate = frdate;
	}

	@Override
	public String toString() {
		return "파일 보드 [fnum=" + fnum + ", cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", fsubject="
				+ fsubject + ", fcontent=" + fcontent + ", ffilename=" + ffilename + ", freadcount=" + freadcount
				+ ", fpw=" + fpw + ", fref=" + fref + ", frestep=" + frestep + ", frelevel=" + frelevel + ", fip=" + fip
				+ ", frdate=" + frdate + "]";
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getFsubject() {
		return fsubject;
	}

	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFfilename() {
		return ffilename;
	}

	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}

	public int getFreadcount() {
		return freadcount;
	}

	public void setFreadcount(int freadcount) {
		this.freadcount = freadcount;
	}

	public String getFpw() {
		return fpw;
	}

	public void setFpw(String fpw) {
		this.fpw = fpw;
	}

	public int getFref() {
		return fref;
	}

	public void setFref(int fref) {
		this.fref = fref;
	}

	public int getFrestep() {
		return frestep;
	}

	public void setFrestep(int frestep) {
		this.frestep = frestep;
	}

	public int getFrelevel() {
		return frelevel;
	}

	public void setFrelevel(int frelevel) {
		this.frelevel = frelevel;
	}

	public String getFip() {
		return fip;
	}

	public void setFip(String fip) {
		this.fip = fip;
	}

	public Timestamp getfRdate() {
		return frdate;
	}

	public void setfRdate(Timestamp frdate) {
		this.frdate = frdate;
	}
	
}
