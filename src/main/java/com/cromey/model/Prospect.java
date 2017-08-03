package com.cromey.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Our very important and sophisticated data model
 */
@SuppressWarnings("serial")
@Document(collection = "prospects")
public class Prospect implements Serializable {

	@Id
	String id;
	String uuid;
	String email;
	String source;
	String token;
	String ip_address;
	String createdOn;
	String updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUUID() {
		return uuid;
	}

	public void setUUID(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	/*@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Prospect prospect = (Prospect) o;

		if (getUUID() != null ? !getUUID().equals(prospect.getUUID()) : prospect.getUUID() != null) {
			return false;
		}

		if (getEmail() != null ? !getEmail().equals(prospect.getEmail()) : prospect.getEmail() != null) {
			return false;
		}
		return !(getEmail() != null ? !getEmail().equals(prospect.getEmail()) : prospect.getEmail() != null);

	}

	@Override
	public int hashCode() {
		int result = getUUID() != null ? getUUID().hashCode() : 0;
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		return result;
	}*/

}
