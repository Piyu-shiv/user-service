package com.prodev.user.userservice.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.prodev.user.userservice.model.response.UserResponseEntity;
import com.prodev.user.userservice.utility.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
//    public UserResponseEntity loadUserByUsername();

public UserResponseEntity  saveUser(UserDTO user);

public UserResponseEntity getUserByID();


public UserResponseEntity getUserByPhoneNo(String phoneNo);



public UserResponseEntity getUserList();



}
