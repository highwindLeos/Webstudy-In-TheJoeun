package com.tj.dto;

public class CustomerDto {
	
	private String cid;
	private String cpw;
	private String cname;
	private String ctel;
	private String cemail;
	private String cgender;
	private String caddr;
	
	public CustomerDto() { }

	public CustomerDto(String cid, String cpw, String cname, String ctel, String cemail, String cgender, String caddr) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.ctel = ctel;
		this.cemail = cemail;
		this.cgender = cgender;
		this.caddr = caddr;
	}

	@Override
	public String toString() {
		return "고객 데이터 [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", ctel=" + ctel + ", cemail=" + cemail
				+ ", cgender=" + cgender + ", caddr=" + caddr + "]";
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

}
