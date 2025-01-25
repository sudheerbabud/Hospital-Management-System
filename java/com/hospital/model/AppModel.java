package com.hospital.model;

public class AppModel {
	private int aid;
	private int pid;
	private int did;
	private String adate;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "AppModel [aid=" + aid + ", pid=" + pid + ", did=" + did + ", adate=" + adate + "]";
	}
	public AppModel(int aid, int pid, int did, String adate) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.did = did;
		this.adate = adate;
	}
	public AppModel() {}
	
}
