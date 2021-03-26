package com.asteelflash.print.app.utils;

public class WindowsTask {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public long getMem() {
		return mem;
	}
	public void setMem(long mem) {
		this.mem = mem;
	}
	private Integer pid;
	private String sessionName;
	private Integer sessionId;
	private long mem;
}
