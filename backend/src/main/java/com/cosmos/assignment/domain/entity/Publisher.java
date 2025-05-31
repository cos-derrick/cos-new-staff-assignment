package com.cosmos.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="JEFF_CHEE_PUBLISHER")
public class Publisher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2218014691195811798L;
	@Id
	@Column(name="PUBLISHER_ID")
	private String publisherId;
	@Column(name="PUBLISHER_NAME")
	private String publisherName;
	@Column(name="PUBLISHER_EMAIL")
	private String publisherEmail;
	@Column(name="PUBLISHER_ADDRESS")
	private String publisherAddress;
	@Column(name="PUBLISHER_TELEPHONE")
	private String publisherTelephone;
	@Column(name="PUBLISHER_FAX")
	private String publisherFax;
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherEmail() {
		return publisherEmail;
	}
	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	public String getPublisherTelephone() {
		return publisherTelephone;
	}
	public void setPublisherTelephone(String publisherTelephone) {
		this.publisherTelephone = publisherTelephone;
	}
	public String getPublisherFax() {
		return publisherFax;
	}
	public void setPublisherFax(String publisherFax) {
		this.publisherFax = publisherFax;
	}
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherEmail="
				+ publisherEmail + ", publisherAddress=" + publisherAddress + ", publisherTelephone="
				+ publisherTelephone + ", publisherFax=" + publisherFax + "]";
	}
	
	
}
