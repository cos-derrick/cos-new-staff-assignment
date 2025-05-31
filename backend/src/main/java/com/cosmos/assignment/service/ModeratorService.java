package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Moderator;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ModeratorService {
	void addModerator(final Moderator moderator);
	void updateModerator(final Moderator moderator);
	void deleteByModeratorId(final String moderatorId);
	void updateModeratorLoginDate(final Moderator moderator);
	
	public String getModeratorId(final String moderatorUsername, final String moderatorPw);
	Moderator getById(final String moderatorId);
	List<Moderator> findAllModerator();
}
