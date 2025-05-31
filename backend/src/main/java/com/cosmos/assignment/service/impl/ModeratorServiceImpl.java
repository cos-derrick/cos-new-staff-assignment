package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.ModeratorDao;
import com.cosmos.assignment.domain.entity.Moderator;
import com.cosmos.assignment.service.ModeratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ModeratorServiceImpl implements ModeratorService{

	@Inject
	private ModeratorDao moderatorDao;
	
	@Override
	@Transactional
	public void addModerator(Moderator moderator) {
		moderatorDao.add(moderator);
	}

	@Override
	@Transactional
	public void updateModerator(Moderator moderator) {
		moderatorDao.update(moderator);
	}

	@Override
	@Transactional
	public void deleteByModeratorId(String moderatorId) {
		moderatorDao.deleteById(moderatorId);
	}

	@Override
	@Transactional
	public void updateModeratorLoginDate(Moderator moderator) {
		moderatorDao.update(moderator);
	}

	@Override
	@Transactional(readOnly=true)
	public String getModeratorId(String moderatorUsername, String moderatorPw) {
		return moderatorDao.getModeratorId(moderatorUsername, moderatorPw);
	}

	@Override
	@Transactional(readOnly=true)
	public Moderator getById(String moderatorId) {
		return moderatorDao.getById(moderatorId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Moderator> findAllModerator() {
		return moderatorDao.findAll();
	}

}
