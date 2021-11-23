package com.lti.bean;

public class Admin {

	private int adminId;
	private int adminPass;
	private String adminName;
	private long phoneNumber;

	/**
	 * @return the adminPass
	 */
	public int getAdminPass() {
		return adminPass;
	}

	/**
	 * @param adminPass the adminPass to set
	 */
	public void setAdminPass(int adminPass) {
		this.adminPass = adminPass;
	}

	
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
