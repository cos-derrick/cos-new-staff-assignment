package com.cosmos.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="JEFF_CHEE_AUTHOR")
public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1256815079754793485L;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorCountry == null) ? 0 : authorCountry.hashCode());
		result = prime * result + ((authorEmail == null) ? 0 : authorEmail.hashCode());
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorCountry == null) {
			if (other.authorCountry != null)
				return false;
		} else if (!authorCountry.equals(other.authorCountry))
			return false;
		if (authorEmail == null) {
			if (other.authorEmail != null)
				return false;
		} else if (!authorEmail.equals(other.authorEmail))
			return false;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="author_seq")
	@SequenceGenerator(name="author_seq", sequenceName="author_seq")*/
	@Column(name="AUTHOR_ID")
	private String authorId;
	@Column(name="AUTHOR_NAME")
	private String authorName;
	@Column(name="AUTHOR_EMAIL")
	private String authorEmail;
	@Column(name="AUTHOR_COUNTRY")
	private String authorCountry;
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorCountry() {
		return authorCountry;
	}
	public void setAuthorCountry(String authorCountry) {
		this.authorCountry = authorCountry;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+ ", authorCountry=" + authorCountry + "]";
	}
	
}
