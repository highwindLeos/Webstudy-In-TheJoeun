package com.ssbit.emp.model;

public class Is_Mater {

	private String user_No;      //VARCHAR2(4) NOT NULL,  --회원일련번호
	private String kor_Name;     //VARCHAR2(20) NULL,     --한글이름
	private String  eng_Name;    // VARCHAR2(20) NULL,     --영문이름
	private String  han_Name;    // VARCHAR2(20) NULL,     --한문이름
	private String  jumin_No;    // VARCHAR2(14) NULL,     --주민번호
	private String  sajin_Nm;    // VARCHAR2(50) NULL,     --사진파일명(사진경로)
	private String  birth_Ymd;   // VARCHAR2(8) NULL,      --생년월일
	private String  birth_Rn;    //VARCHAR2(1) NULL,      --양음력 (1이면 양력, 2이면 음력)
	private String  sex;         // VARCHAR2(1) NULL,      --성별 (1이면 남자, 2이면 여자)
	private String  marry_Yn;    // VARCHAR2(1) NULL,      --결혼유무 (0이면미혼, 1이면기혼)
	private String  work_Year;   // VARCHAR2(2) NULL,      --년차
	private String  join_St;     // VARCHAR2(1) NULL,      --입사유형 (0이면 정규직, 1이면 계약직)
	private String hope_Work;    //VARCHAR2(1) NULL,      --희망직무 (0이면 SI, 1이면 SM)
	private String addr;         // VARCHAR2(50) NULL,     --주소
	private String tel;          // VARCHAR2(20) NULL,     --연락처
	private String  email;       // VARCHAR2(20) NULL,     --이메일
	private String tech_Grd;     // VARCHAR2(20) NULL,     --기술등급 (고급, 중급, 초급)
	private String  alc_Qt;      // VARCHAR2(20) NULL     --주량
	
	private int startRow;            // 페이징변수
	private int  endRow;             // 페이징변수
	
	@Override
	public String toString() {
		return "Is_Mater [user_No=" + user_No + ", kor_Name=" + kor_Name + ", eng_Name=" + eng_Name + ", han_Name="
				+ han_Name + ", jumin_No=" + jumin_No + ", sajin_Nm=" + sajin_Nm + ", birth_Ymd=" + birth_Ymd
				+ ", birth_Rn=" + birth_Rn + ", sex=" + sex + ", marry_Yn=" + marry_Yn + ", work_Year=" + work_Year
				+ ", join_St=" + join_St + ", hope_Work=" + hope_Work + ", addr=" + addr + ", tel=" + tel + ", email="
				+ email + ", tech_Grd=" + tech_Grd + ", alc_Qt=" + alc_Qt + ", startRow=" + startRow + ", endRow="
				+ endRow + "]";
	}
	
	public String getUser_No() {
		return user_No;
	}
	public void setUser_No(String user_No) {
		this.user_No = user_No;
	}
	public String getKor_Name() {
		return kor_Name;
	}
	public void setKor_Name(String kor_Name) {
		this.kor_Name = kor_Name;
	}
	public String getEng_Name() {
		return eng_Name;
	}
	public void setEng_Name(String eng_Name) {
		this.eng_Name = eng_Name;
	}
	public String getHan_Name() {
		return han_Name;
	}
	public void setHan_Name(String han_Name) {
		this.han_Name = han_Name;
	}
	public String getJumin_No() {
		return jumin_No;
	}
	public void setJumin_No(String jumin_No) {
		this.jumin_No = jumin_No;
	}
	public String getSajin_Nm() {
		return sajin_Nm;
	}
	public void setSajin_Nm(String sajin_Nm) {
		this.sajin_Nm = sajin_Nm;
	}
	public String getBirth_Ymd() {
		return birth_Ymd;
	}
	public void setBirth_Ymd(String birth_Ymd) {
		this.birth_Ymd = birth_Ymd;
	}
	public String getBirth_Rn() {
		return birth_Rn;
	}
	public void setBirth_Rn(String birth_Rn) {
		this.birth_Rn = birth_Rn;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarry_Yn() {
		return marry_Yn;
	}
	public void setMarry_Yn(String marry_Yn) {
		this.marry_Yn = marry_Yn;
	}
	public String getWork_Year() {
		return work_Year;
	}
	public void setWork_Year(String work_Year) {
		this.work_Year = work_Year;
	}
	public String getJoin_St() {
		return join_St;
	}
	public void setJoin_St(String join_St) {
		this.join_St = join_St;
	}
	public String getHope_Work() {
		return hope_Work;
	}
	public void setHope_Work(String hope_Work) {
		this.hope_Work = hope_Work;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTech_Grd() {
		return tech_Grd;
	}
	public void setTech_Grd(String tech_Grd) {
		this.tech_Grd = tech_Grd;
	}
	public String getAlc_Qt() {
		return alc_Qt;
	}
	public void setAlc_Qt(String alc_Qt) {
		this.alc_Qt = alc_Qt;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

}
