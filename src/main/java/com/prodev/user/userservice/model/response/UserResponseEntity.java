package com.prodev.user.userservice.model.response;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.prodev.user.userservice.model.User;
import com.prodev.user.userservice.model.request.UserResponseModel;

@JacksonXmlRootElement
public class UserResponseEntity {

    private boolean success = false;
    private Map<Integer, User> userList = null;
    private String responseMsg = null;
    private UserResponseModel user = null;

    public UserResponseEntity() {
        // TODO Auto-generated constructor stub
        this.userList = new HashMap<Integer, User>();
    }


    public UserResponseEntity(boolean success, Map<Integer, User> userList, String responseMsg, UserResponseModel user) {
        super();
        this.success = success;
        this.userList = userList;
        this.responseMsg = responseMsg;
        this.user = user;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Map<Integer, User> getUserList() {
        return userList;
    }


    public void setUserList(Map<Integer, User> userList) {
        this.userList = userList;
    }


    public String getResponseMsg() {
        return responseMsg;
    }


    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    public UserResponseModel getUser() {
        return user;
    }


    public void setUser(UserResponseModel user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserResponseEntity [success=" + success + ", userList=" + userList + ", responseMsg=" + responseMsg
                + ", user=" + user + "]";
    }

}
