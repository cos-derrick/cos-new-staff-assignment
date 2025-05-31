package com.cosmos.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="JEFF_CHEE_MODERATOR")
public class Moderator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442042459709856827L;

	@Id
	@Column(name="MODERATOR_ID")
	private String moderatorId;
	@Column(name="MODERATOR_USERNAME")
	private String moderatorUsername;
	@Column(name="MODERATOR_PW")
	private String moderatorPw;
	@Column(name="MODERATOR_ENABLE")
	private int moderatorEnable;
	@Column(name="MODERATOR_LAST_LOGIN_DATE")
	private Date moderatorLastLoginDate;
	
	public String getModeratorId() {
		return moderatorId;
	}
	public void setModeratorId(String moderatorId) {
		this.moderatorId = moderatorId;
	}
	public String getModeratorUsername() {
		return moderatorUsername;
	}
	public void setModeratorUsername(String moderatorUsername) {
		this.moderatorUsername = moderatorUsername;
	}
	public String getModeratorPw() {
		return moderatorPw;
	}
	public void setModeratorPw(String moderatorPw) {
		this.moderatorPw = moderatorPw;
	}
	public int getModeratorEnable() {
		return moderatorEnable;
	}
	public void setModeratorEnable(int moderatorEnable) {
		this.moderatorEnable = moderatorEnable;
	}
	public Date getModeratorLastLoginDate() {
		return moderatorLastLoginDate;
	}
	public void setModeratorLastLoginDate(Date moderatorLastLoginDate) {
		this.moderatorLastLoginDate = moderatorLastLoginDate;
	}

}
