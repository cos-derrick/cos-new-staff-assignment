package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.UserDao;
import com.cosmos.assignment.domain.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractGenericDao<User,String> implements UserDao{

	@Override
	public String getUserId(String userName, String userPw) {
		String hql = "SELECT U.userId FROM User U WHERE U.userUsername = '"+userName+"' AND U.userPw = '"+userPw+"'";
		Query query = getSession().createQuery(hql);
		String result = (String) query.uniqueResult();
		return result;
	}
	
	@Override
	public double getUserAcctBalance(String userId) {
		Criteria cr = getSession().createCriteria(User.class)
				.add(Restrictions.eq("userUserId", userId));
						
				Object result = cr.uniqueResult();
				if (result != null) {
					User user = (User) result;
					double balance = user.getUserAcctBalance();
					return balance;
				}else{
					return -1;
				}
	}
}
