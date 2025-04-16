package com.prodev.user.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="UserAccounts")
public class User implements Serializable {


	@Serial
	private static final long serialVersionUID = 4754214572576235655L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = true, length = 50)
	private String details;
	@Column(nullable = false, length = 50)
	private double salary;
	@Column(nullable = false)
	private String encryptedPassword;

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	@Column(nullable = false, unique = true)
	private String phoneNo;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String userId, String name, String details, double salary, String encryptedPassword, String phoneNo) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.details = details;
		this.salary = salary;
		this.encryptedPassword = encryptedPassword;
		this.phoneNo = phoneNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userId='" + userId + '\'' +
				", name='" + name + '\'' +
				", details='" + details + '\'' +
				", salary=" + salary +
				", encryptedPassword='" + encryptedPassword + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				'}';
	}
}

