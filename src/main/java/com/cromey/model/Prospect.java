package com.cromey.model;

import java.io.Serializable;

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

	@Override
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
	}

}
