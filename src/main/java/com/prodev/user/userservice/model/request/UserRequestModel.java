package com.prodev.user.userservice.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;



public class UserRequestModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1650195842368524925L;

	private String id;
	@NotNull(message="cannot be null")
	@Size(min = 6,message = "first name should be longer than two character")
	private String name;
	private String details;
	private double salary;
	private String password;
	private String encryptedPassword;
	private String phoneNo;

	public UserRequestModel() {
		// TODO Auto-generated constructor stub
	}


	public UserRequestModel(String id,
			@NotNull(message = "cannot be null") @Size(min = 6, message = "first name should be longer than two character") String name,
			String details, double salary, String password, String encryptedPassword,String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.salary = salary;
		this.password = password;
		this.encryptedPassword = encryptedPassword;
		this.phoneNo=phoneNo;
	}





	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}


	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	@Override
	public String toString() {
		return "UserRequestModel [id=" + id + ", name=" + name + ", details=" + details + ", salary=" + salary
				+ ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}






}
