package com.prodev.user.userservice.model.request;

public class UserLoginModel {

private String phoneNo;
private String password;
	
public UserLoginModel() {
	// TODO Auto-generated constructor stub
}

public UserLoginModel(String phoneNo, String password) {
	super();
	this.phoneNo = phoneNo;
	this.password = password;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}




public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "UserLoginModel [phoneNo=" + phoneNo + "]";
}


}
