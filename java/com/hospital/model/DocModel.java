package com.hospital.model;

public class DocModel {
	private int did;
	private String dname;
	private String dspecialization;
	private String dgender;
	
	public DocModel(int did, String dname, String dspecialization, String dgender) {
		super();
		this.did = did;
		this.dname = dname;
		this.dspecialization = dspecialization;
		this.dgender = dgender;
	}

	@Override
	public String toString() {
		return "DocModel [did=" + did + ", dname=" + dname + ", dspecialization=" + dspecialization + ", dgender="
				+ dgender + "]";
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDspecialization() {
		return dspecialization;
	}

	public void setDspecialization(String dspecialization) {
		this.dspecialization = dspecialization;
	}

	public String getDgender() {
		return dgender;
	}

	public void setDgender(String dgender) {
		this.dgender = dgender;
	}

	public DocModel() {}
}
