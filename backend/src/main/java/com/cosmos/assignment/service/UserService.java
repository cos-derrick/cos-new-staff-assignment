package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {
	void addUser(final User user);
	void updateUser(final User user);
	void deleteByUserId(final String userId);
	void approveUser(final User user);
	void unlockUser(final User user);
	void updateUserLoginDate(final User user);
	void updateUserNumberOfRetries(final User user);
	
	public String getUserId(final String userUserName, final String userPw);
	public double getUserAcctBalance(final String userId);
	User getById(final String userId);
	List<User> findAllUser();
}
