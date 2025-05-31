package com.cosmos.assignment.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="JEFF_CHEE_USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(name="USER_USERNAME")
	private String userUsername;
	@Column(name="USER_PW")
	private String userPw;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_EMAIL")
	private String userEmail;
	@Column(name="USER_TELEPHONE")
	private String userTelephone;
	@Column(name="USER_MOBILE")
	private String userMobile;
	@Column(name="USER_ADDRESS")
	private String userAddress;
	@Column(name="USER_STATUS")
	private String userStatus;
	@Column(name="USER_CREATED_DATE")
	private Date userCreatedDate;
	@Column(name="USER_UPDATED_DATE")
	private Date userUpdatedDate;
	@Column(name="USER_APPROVED_DATE")
	private Date userApprovedDate;
	@ManyToOne
	@JoinColumn(name="USER_APPROVED_BY")
	private Moderator userApprovedBy;
	@Column(name="USER_NUMBER_OF_RETRIES")
	private int userNumberOfRetries;
	@Column(name="USER_LAST_LOGIN_DATE")
	private Date userLastLoginDate;
	@Column(name="USER_ACCT_BALANCE")
	private double userAcctBalance;
	
//	private Shelf shelf;
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "shelfUser", cascade = CascadeType.ALL)
//	public Shelf getShelf() {
//		return shelf;
//	}
//	public void setShelf(Shelf shelf) {
//		this.shelf = shelf;
//	}
//	
	public Date getUserCreatedDate() {
		return userCreatedDate;
	}
	
	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}
	public Date getUserUpdatedDate() {
		return userUpdatedDate;
	}
	public void setUserUpdatedDate(Date userUpdatedDate) {
		this.userUpdatedDate = userUpdatedDate;
	}
	public Date getUserApprovedDate() {
		return userApprovedDate;
	}
	public void setUserApprovedDate(Date userApprovedDate) {
		this.userApprovedDate = userApprovedDate;
	}
	public Moderator getUserApprovedBy() {
		return userApprovedBy;
	}
	public void setUserApprovedBy(Moderator userApprovedBy) {
		this.userApprovedBy = userApprovedBy;
	}
	public int getUserNumberOfRetries() {
		return userNumberOfRetries;
	}
	public void setUserNumberOfRetries(int userNumberOfRetries) {
		this.userNumberOfRetries = userNumberOfRetries;
	}
	public Date getUserLastLoginDate() {
		return userLastLoginDate;
	}
	public void setUserLastLoginDate(Date userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public double getUserAcctBalance() {
		return userAcctBalance;
	}
	public void setUserAcctBalance(double userAcctBalance) {
		this.userAcctBalance = userAcctBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(userAcctBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userApprovedBy == null) ? 0 : userApprovedBy.hashCode());
		result = prime * result + ((userApprovedDate == null) ? 0 : userApprovedDate.hashCode());
		result = prime * result + ((userCreatedDate == null) ? 0 : userCreatedDate.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLastLoginDate == null) ? 0 : userLastLoginDate.hashCode());
		result = prime * result + ((userMobile == null) ? 0 : userMobile.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + userNumberOfRetries;
		result = prime * result + ((userPw == null) ? 0 : userPw.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userName.hashCode());
		result = prime * result + ((userTelephone == null) ? 0 : userTelephone.hashCode());
		result = prime * result + ((userUpdatedDate == null) ? 0 : userUpdatedDate.hashCode());
		result = prime * result + ((userUsername == null) ? 0 : userUsername.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(userAcctBalance) != Double.doubleToLongBits(other.userAcctBalance))
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userApprovedBy == null) {
			if (other.userApprovedBy != null)
				return false;
		} else if (!userApprovedBy.equals(other.userApprovedBy))
			return false;
		if (userApprovedDate == null) {
			if (other.userApprovedDate != null)
				return false;
		} else if (!userApprovedDate.equals(other.userApprovedDate))
			return false;
		if (userCreatedDate == null) {
			if (other.userCreatedDate != null)
				return false;
		} else if (!userCreatedDate.equals(other.userCreatedDate))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLastLoginDate == null) {
			if (other.userLastLoginDate != null)
				return false;
		} else if (!userLastLoginDate.equals(other.userLastLoginDate))
			return false;
		if (userMobile == null) {
			if (other.userMobile != null)
				return false;
		} else if (!userMobile.equals(other.userMobile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userNumberOfRetries != other.userNumberOfRetries)
			return false;
		if (userPw == null) {
			if (other.userPw != null)
				return false;
		} else if (!userPw.equals(other.userPw))
			return false;
		if (userStatus != other.userStatus)
			return false;
		if (userTelephone == null) {
			if (other.userTelephone != null)
				return false;
		} else if (!userTelephone.equals(other.userTelephone))
			return false;
		if (userUpdatedDate == null) {
			if (other.userUpdatedDate != null)
				return false;
		} else if (!userUpdatedDate.equals(other.userUpdatedDate))
			return false;
		if (userUsername == null) {
			if (other.userUsername != null)
				return false;
		} else if (!userUsername.equals(other.userUsername))
			return false;
		return true;
	}
	
	
}
