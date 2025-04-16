package com.prodev.user.userservice.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.prodev.user.userservice.model.User;
import com.prodev.user.userservice.model.request.UserRequestModel;
import com.prodev.user.userservice.model.response.UserResponseEntity;
import com.prodev.user.userservice.utility.UserDTO;

public interface UserService  {
//    public UserResponseEntity loadUserByUsername();

public UserResponseEntity  saveUser(UserDTO user);

public UserResponseEntity getUserByID();


public UserResponseEntity getUserByPhoneNo(String phoneNo);



public UserResponseEntity getUserList();



}
