package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends GenericDao<User, String> {
	public String getUserId(final String userName, final String userPw);
	public double getUserAcctBalance(final String userId);
}
