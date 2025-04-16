package com.prodev.user.userservice.controller;


import com.prodev.user.userservice.service.UserService;
import com.prodev.user.userservice.utility.ModelMapper;
import com.prodev.user.userservice.utility.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.prodev.user.userservice.model.request.UserRequestModel;
import com.prodev.user.userservice.model.response.UserResponseEntity;


@RestController
@RequestMapping("/public/v1/ecom/user")
public class UserController {

    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;

    private ModelMapper<UserDTO, UserRequestModel> mapper = new ModelMapper<UserDTO, UserRequestModel>();

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public UserResponseEntity statusCheck() {
        System.out.println("RUNNING ON PORT************************************************" + env.getProperty("local.server.port"));
        return new UserResponseEntity();
    }

    @ResponseBody
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseEntity createUser(@Valid @RequestBody UserRequestModel user) {
        System.out.println("came in user controlller post method" + user);
        UserDTO userDto = new UserDTO();
        mapper.mapObject(userDto, user);
        return userService.saveUser(userDto);
    }
//	@GetMapping("/{id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ProductResponseEntity getProductByID(@PathVariable("id") int productID){
//		
//	return productService.getProductByID(productID,productResponseEntity);	
//		
//	}
//
//	
//	@ResponseBody
//	@PostMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})	
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public UserResponseEntity userLogin(@RequestBody UserLoginModel cred){
//		System.out.println("came in user controlller  login post method"+cred);
//	return userService.getUserByPhoneNo(cred.getPhoneNo());
////		return userService.loadUserByUsername(cred.getPhoneNo());
//		
//	}
//	

}
