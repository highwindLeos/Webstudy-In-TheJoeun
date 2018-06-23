package com.tj.ex.dto;
import java.sql.Timestamp;
public class FileboardDto {
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
	private int fre_step;
	private int fre_level;
	private String fip;
	private Timestamp frdate;
	public FileboardDto() { }
	public FileboardDto(int fnum, String cid, String cname, String cemail, String fsubject, String fcontent,
			String ffilename, int freadcount, String fpw, int fref, int fre_step, int fre_level, String fip,
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
		this.fre_step = fre_step;
		this.fre_level = fre_level;
		this.fip = fip;
		this.frdate = frdate;
	}
	public int getFnum() {return fnum;}
	public void setFnum(int fnum) {this.fnum = fnum;}
	public String getCid() {return cid;}
	public void setCid(String cid) {this.cid = cid;}
	public String getCname() {return cname;}
	public void setCname(String cname) {this.cname = cname;}
	public String getCemail() {return cemail;}
	public void setCemail(String cemail) {this.cemail = cemail;}
	public String getFsubject() {return fsubject;}
	public void setFsubject(String fsubject) {this.fsubject = fsubject;}
	public String getFcontent() {return fcontent;}
	public void setFcontent(String fcontent) {this.fcontent = fcontent;}
	public String getFfilename() {return ffilename;}
	public void setFfilename(String ffilename) {this.ffilename = ffilename;}
	public int getFreadcount() {return freadcount;}
	public void setFreadcount(int freadcount) {this.freadcount = freadcount;}
	public String getFpw() {return fpw;}
	public void setFpw(String fpw) {this.fpw = fpw;}
	public int getFref() {return fref;}
	public void setFref(int fref) {this.fref = fref;}
	public int getFre_step() {return fre_step;}
	public void setFre_step(int fre_step) {this.fre_step = fre_step;}
	public int getFre_level() {return fre_level;}
	public void setFre_level(int fre_level) {this.fre_level = fre_level;}
	public String getFip() {return fip;}
	public void setFip(String fip) {this.fip = fip;}
	public Timestamp getFrdate() {return frdate;}
	public void setFrdate(Timestamp frdate) {this.frdate = frdate;}
	@Override
	public String toString() {
		return "FileboardDto [fnum=" + fnum + ", cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", fsubject="
				+ fsubject + ", fcontent=" + fcontent + ", ffilename=" + ffilename + ", freadcount=" + freadcount
				+ ", fpw=" + fpw + ", fref=" + fref + ", fre_step=" + fre_step + ", fre_level=" + fre_level + ", fip="
				+ fip + ", frdate=" + frdate + "]";
	}
}