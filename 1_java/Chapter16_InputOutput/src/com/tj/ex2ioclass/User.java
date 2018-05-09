package com.tj.ex2ioclass;

public class User {
	private String id;
	private String ip;
	private int time;
	
	public User () {}

	public User(String id, String ip, int time) {
		this.id = id;
		this.ip = ip;
		this.time = time;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", ip=" + ip + ", time=" + time + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
