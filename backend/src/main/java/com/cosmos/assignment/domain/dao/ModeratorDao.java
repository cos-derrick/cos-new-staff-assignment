package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Moderator;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorDao extends GenericDao<Moderator, String> {
	public String getModeratorId(final String moderatorUsername, final String moderatorPw);
}
