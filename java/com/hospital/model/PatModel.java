package com.hospital.model;

public class PatModel {
	private int pid;
	private String pname;
	private int page;
	private String pgender;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPgender() {
		return pgender;
	}
	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	@Override
	public String toString() {
		return "AddModel [pid=" + pid + ", pname=" + pname + ", page=" + page + ", pgender=" + pgender + "]";
	}
	public PatModel(int pid, String pname, int page, String pgender) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.page = page;
		this.pgender = pgender;
	}
	
	public PatModel(){}
}
