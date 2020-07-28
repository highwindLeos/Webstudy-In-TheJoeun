package com.ssbit.emp.model;

public class Is_Mater {

	private String user_No;      //VARCHAR2(4) NOT NULL,  --ȸ���Ϸù�ȣ
	private String kor_Name;     //VARCHAR2(20) NULL,     --�ѱ��̸�
	private String  eng_Name;    // VARCHAR2(20) NULL,     --�����̸�
	private String  han_Name;    // VARCHAR2(20) NULL,     --�ѹ��̸�
	private String  jumin_No;    // VARCHAR2(14) NULL,     --�ֹι�ȣ
	private String  sajin_Nm;    // VARCHAR2(50) NULL,     --�������ϸ�(�������)
	private String  birth_Ymd;   // VARCHAR2(8) NULL,      --�������
	private String  birth_Rn;    //VARCHAR2(1) NULL,      --������ (1�̸� ���, 2�̸� ����)
	private String  sex;         // VARCHAR2(1) NULL,      --���� (1�̸� ����, 2�̸� ����)
	private String  marry_Yn;    // VARCHAR2(1) NULL,      --��ȥ���� (0�̸��ȥ, 1�̸��ȥ)
	private String  work_Year;   // VARCHAR2(2) NULL,      --����
	private String  join_St;     // VARCHAR2(1) NULL,      --�Ի����� (0�̸� ������, 1�̸� �����)
	private String hope_Work;    //VARCHAR2(1) NULL,      --������� (0�̸� SI, 1�̸� SM)
	private String addr;         // VARCHAR2(50) NULL,     --�ּ�
	private String tel;          // VARCHAR2(20) NULL,     --����ó
	private String  email;       // VARCHAR2(20) NULL,     --�̸���
	private String tech_Grd;     // VARCHAR2(20) NULL,     --������ (���, �߱�, �ʱ�)
	private String  alc_Qt;      // VARCHAR2(20) NULL     --�ַ�
	
	private int startRow;            // ����¡����
	private int  endRow;             // ����¡����
	
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
