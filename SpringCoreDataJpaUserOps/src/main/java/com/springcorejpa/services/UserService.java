package com.springcorejpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcorejpa.model.UserInfo;
import com.springcorejpa.repository.UserInfoDAO;

@Service
public class UserService {
	@Autowired
	private UserInfoDAO userInfoDAO;

	public void addUser(UserInfo userInfo) {
		userInfoDAO.save(userInfo);
	}

	public boolean updateUser(UserInfo userInfo) {
		return userInfoDAO.save(userInfo) != null;
	}

	public List<UserInfo> getAllUsers() {
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoDAO.findAll().forEach(userInfoList::add);
		return userInfoList;
	}

	public UserInfo getById(String userID) {
		// return userInfoDAO.findOne(id);
		return null;
	}

	public List<UserInfo> findByLastName(String lastName) {
		return userInfoDAO.findByLastName(lastName);
	}

	public void deleteUser(String userID) {
		// userInfoDAO.delete(userID);
	}
}