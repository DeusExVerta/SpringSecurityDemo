package com.Howard.service;

import java.util.List;

import com.Howard.dto.UserDTO;
import com.Howard.entity.User;

public interface UserService {
	void saveUser(UserDTO userDto);

	User findUserByEmail(String email);

	List<UserDTO> findAllUsers();
}
