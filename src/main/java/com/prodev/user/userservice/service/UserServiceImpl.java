package com.prodev.user.userservice.service;

import java.util.ArrayList;
import java.util.UUID;

import com.prodev.user.userservice.utility.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prodev.user.userservice.model.User;
import com.prodev.user.userservice.model.request.UserRequestModel;
import com.prodev.user.userservice.model.request.UserResponseModel;
import com.prodev.user.userservice.model.response.UserResponseEntity;
import com.prodev.user.userservice.repository.UserRepository;
import com.prodev.user.userservice.utility.ModelMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	private UserResponseEntity response=null;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	private ModelMapper<User, UserDTO> mapper =new ModelMapper<User, UserDTO>();

	private ModelMapper<UserResponseModel, User> mapper2 =new ModelMapper<UserResponseModel, User>();
	private User user =null;

	private UserResponseModel userResponse=null;

	@Override
	public UserResponseEntity saveUser(UserDTO user) {
		// TODO Auto-generated method stub

		user.setId(UUID.randomUUID().toString());
		user.setEncryptedPassword(bcryptPasswordEncoder.encode(user.getPassword()));

		User userModel =new User();
		System.out.println("came in user service  method"+user);
		userModel=mapper.mapObject(userModel, user);
		System.out.println("printing object after being mapped."+userModel);
		response=new UserResponseEntity();
		try {
			System.out.println(repository.save(userModel)+"save user");
			userResponse =new UserResponseModel();
			System.out.println("aftere reconverting ...."+userResponse);
			mapper2.mapObject(userResponse, userModel);
			response.setUser(userResponse);
			response.setResponseMsg("SUCCESS");
			response.setSuccess(true);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
			response.setResponseMsg(e.getMessage());
		}
		System.out.println("returning result......");
		return response ;
	}


	@Override
	public UserResponseEntity getUserByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseEntity getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseEntity getUserByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub

		user=repository.findByPhoneNo(phoneNo);
		System.out.println("printing user fetched...."+user);
		userResponse =new UserResponseModel();
		mapper2.mapObject(userResponse,user);
		System.out.println("after converting,,,,,"+userResponse);

		if(user!=null) {
			response.setUser(userResponse);
			response.setSuccess(true);
			response.setResponseMsg("FETCH_SUCCESS");
		}
		else {
//			throw new UsernameNotFoundException("user is not found");
			response.setUser(null);
			response.setSuccess(false);
			response.setResponseMsg("FETCH_FAILURE");
		}

		return response;
	}



//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//
//		User user=repository.findByPhoneNo(username);
//		if(user==null) throw new UsernameNotFoundException("User is not there id DB");
//
//		return new org.springframework.security.core.userdetails.User(user.getPhoneNo(), user.getEncryptedPassword(), true,true,true, true, new ArrayList<>());
//		//		response=new UserResponseEntity();
//		//
//		//		response.setUser(null);
//		//		if(null!=userDetails.getUsername()) {
//		//		response.setResponseMsg("SUCCESS");
//		//
//		//		response.setSuccess(true);
//		//	}
//		//	return
//	}

}
