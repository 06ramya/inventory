package com.edu.SpringBootCustomerApp.Service;

import java.util.Optional;

import com.edu.SpringBootCustomerApp.Entity.User;

public interface UserService {
	public Optional<User> findUserByUserName(String userName);
}
