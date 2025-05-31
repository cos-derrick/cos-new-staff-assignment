package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.ModeratorDao;
import com.cosmos.assignment.domain.entity.Moderator;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ModeratorDaoImpl extends AbstractGenericDao<Moderator,String> implements ModeratorDao {
	
	@Override
	public String getModeratorId(String moderatorUsername, String moderatorPw) {
		String hql = "SELECT M.moderatorId FROM Moderator M WHERE M.moderatorUsername = '"+moderatorUsername+"' AND M.moderatorPw = '"+moderatorPw+"'";
		Query query = getSession().createQuery(hql);
		String result = (String) query.uniqueResult();
		return result;
	}
}
