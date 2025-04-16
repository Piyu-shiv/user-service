package com.prodev.user.userservice.model.request;

import java.io.Serializable;


public class UserResponseModel implements Serializable {


    public UserResponseModel(String id, String name, String details, double salary, String phoneNo) {
        super();
        this.id = id;
        this.name = name;
        this.details = details;
        this.salary = salary;
        this.phoneNo = phoneNo;
    }


    /**
     *
     */
    private static final long serialVersionUID = 5384016582373590190L;
    private String id;
    private String name;
    private String details;
    private double salary;
    private String phoneNo;

    public UserResponseModel() {
        // TODO Auto-generated constructor stub
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
        return "UserResponseModel [id=" + id + ", name=" + name + ", details=" + details + ", salary=" + salary
                + ", phoneNo=" + phoneNo + "]";
    }

}
