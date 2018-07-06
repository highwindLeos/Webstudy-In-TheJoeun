package com.tj.ex.dto;

public class GoodsDto {
	private String gcode;
	private String gname;
	private int gprice;
	private int gstock;
	
	public GoodsDto() {	}

	public GoodsDto(String gcode, String gname, int gprice, int gstock) {
		this.gcode = gcode;
		this.gname = gname;
		this.gprice = gprice;
		this.gstock = gstock;
	}

	@Override
	public String toString() {
		return "상품 정보 [gcode=" + gcode + ", gname=" + gname + ", gprice=" + gprice + ", gstock=" + gstock + "]";
	}

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGprice() {
		return gprice;
	}

	public void setGprice(int gprice) {
		this.gprice = gprice;
	}

	public int getGstock() {
		return gstock;
	}

	public void setGstock(int gstock) {
		this.gstock = gstock;
	}
	
}
