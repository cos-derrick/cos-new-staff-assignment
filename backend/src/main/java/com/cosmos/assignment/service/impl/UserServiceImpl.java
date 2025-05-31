package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.UserDao;
import com.cosmos.assignment.domain.entity.User;
import com.cosmos.assignment.service.UserService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		int id = findAllUser().size() + 1;
		user.setUserId(Util.generateId("User",id));
		userDao.add(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional
	public void deleteByUserId(String userId) {
		userDao.deleteById(userId);
	}

	@Override
	@Transactional
	public void approveUser(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional
	public void unlockUser(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional
	public void updateUserLoginDate(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional
	public void updateUserNumberOfRetries(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional(readOnly = true)
	public String getUserId(String userUserName, String userPw) {
		return userDao.getUserId(userUserName, userPw);
	}
	
	@Override
	@Transactional(readOnly = true)
	public double getUserAcctBalance(String userId) {
		return userDao.getUserAcctBalance(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public User getById(String userId) {
		return userDao.getById(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllUser() {
		return userDao.findAll();
	}
}
