package com.prodev.user.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.user.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByPhoneNo(String phoneNo);
}
