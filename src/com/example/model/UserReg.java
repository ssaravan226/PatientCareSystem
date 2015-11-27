package com.example.model;

public class UserReg {
	
	String fname, lname,email,pwd, address, ans;
	int ContactNum, EmergenyNum, roleId;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String ename) {
		this.email = ename;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContactNum() {
		return ContactNum;
	}
	public void setContactNum(int num) {
		this.ContactNum = num;
	}
	public int getEmergencyNum() {
		return EmergenyNum;
	}
	public void setEmergencyNum(int enumb) {
		this.EmergenyNum = enumb;
	}
	
	public int getroleId() {
		return roleId;
	}
	public void setroleId(int roleid) {
		this.roleId = roleid;
	}
	public String getans() {
		return ans;
	}
	public void setans(String ans) {
		this.ans = ans;
	}
	

}