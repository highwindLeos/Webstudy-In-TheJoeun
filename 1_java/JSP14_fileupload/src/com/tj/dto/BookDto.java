package com.tj.dto;

public class BookDto {
	private int bid;
	private String bname;
	private int bprice;
	private String bimage1;
	private String bimage2;
	private String bcontent;
	private int bdiscount;
	
	public BookDto() {}

	public BookDto(int bid, String bname, int bprice, String bimage1, String bimage2, String bcontent, int bdiscount) {
		this.bid = bid;
		this.bname = bname;
		this.bprice = bprice;
		this.bimage1 = bimage1;
		this.bimage2 = bimage2;
		this.bcontent = bcontent;
		this.bdiscount = bdiscount;
	}

	@Override
	public String toString() {
		return "책정보 : [책번호  = " + bid + ", 책이름 = " + bname + ", 책가격 = " + bprice + ", 책이미지1 = " + bimage1 + ", 책이미지2 = "
				+ bimage2 + ",  책설명 =" + bcontent + ", 책 할인율 = " + bdiscount + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBimage1() {
		return bimage1;
	}

	public void setBimage1(String bimage1) {
		this.bimage1 = bimage1;
	}

	public String getBimage2() {
		return bimage2;
	}

	public void setBimage2(String bimage2) {
		this.bimage2 = bimage2;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBdiscount() {
		return bdiscount;
	}

	public void setBdiscount(int bdiscount) {
		this.bdiscount = bdiscount;
	}

}
