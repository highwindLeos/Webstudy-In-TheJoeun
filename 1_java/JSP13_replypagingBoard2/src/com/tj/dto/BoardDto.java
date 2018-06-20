package com.tj.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int readCount;
	private String pw;
	private int ref;
	private int reStep;
	private int reLevel;
	private String ip;
	private Timestamp rdate;
	
	// constructor
	public BoardDto() {
		super();
	}
	
	public BoardDto(int num, String writer, String subject, String content, String email, int readCount, String pw,
			int ref, int reStep, int reLevel, String ip, Timestamp rdate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.readCount = readCount;
		this.pw = pw;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.ip = ip;
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "게시판 정보 [글번호 = " + num + ", 글쓴이 = " + writer + ", 글제목 = " + subject + ", 글내용 = " + content
				+ ", 이메일 = " + email + ", 조회수 = " + readCount + ", 패스워드 = " + pw + ", 글그룹 = " + ref + ", 글그룹순서 = " + reStep
				+ ", 글그룹단계 = " + reLevel + ", 아이피 = " + ip + ", 작성시간 = " + rdate + "]";
	}

	// getter setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
}
