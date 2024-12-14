package com.routemasterapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.routemasterapi.api.entity.UsersEntity;
import com.routemasterapi.api.model.UserIdRequest;
import com.routemasterapi.api.model.UserRequestBody;
import com.routemasterapi.api.repositories.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public UsersEntity createUser(UserRequestBody userReqBody) {
		UsersEntity newUser = new UsersEntity();
		newUser.setFirstName(userReqBody.getFirstName());
		newUser.setLastName(userReqBody.getLastName());
		newUser.setEmail(userReqBody.getEmail());
		newUser.setPassword(userReqBody.getPassword());
		newUser.setPhoneNumber(userReqBody.getPhoneNumber());
		return usersRepository.save(newUser);
	}
	
	public UsersEntity updateUser(UserRequestBody userReqBody) {
		UsersEntity newUser= new UsersEntity();
		newUser.setUserId(userReqBody.getUserId());
		newUser.setFirstName(userReqBody.getFirstName());
		newUser.setLastName(userReqBody.getLastName());
		newUser.setEmail(userReqBody.getEmail());
		newUser.setPassword(userReqBody.getPassword());
		newUser.setPhoneNumber(userReqBody.getPhoneNumber());
		return usersRepository.save(newUser);
	}
	
	public Page<UsersEntity> listAllUsersFromDB(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return usersRepository.listAllUsersFromDB(pageable);
	}
	
	public String deleteUser(UserIdRequest userIdReq) {
		int userId = userIdReq.getUserId();
		usersRepository.deleteById(userId);
		return "Record Deleted Successfully";
	}
	
	public String countNumberofUsers() {
		return usersRepository.countNoOfUsers();
	}
}