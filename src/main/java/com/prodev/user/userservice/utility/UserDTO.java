package com.prodev.user.userservice.utility;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;


public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7473661256905137870L;
    private String userId;
    private String name;
    private String details;
    private double salary;
    private String password;
    private String encryptedPassword;
    private String phoneNo;

    public UserDTO() {
    }

    public UserDTO(String userId, String name, String details, double salary, String password, String encryptedPassword, String phoneNo) {
        this.userId = userId;
        this.name = name;
        this.details = details;
        this.salary = salary;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return userId;
    }

    public void setId(String userId) {
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
