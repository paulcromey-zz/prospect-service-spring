package com.cromey.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProspectTest {

	Prospect prospect;

	@Before
	public void setUp() throws Exception {
		
		prospect = new Prospect();
		prospect.setUUID("1");
		prospect.setEmail("firstname.lastname@gmail.com");
		prospect.setSource("source");
		prospect.setToken("token");
		prospect.setCreatedOn(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
		prospect.setUpdatedOn(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
	}

	@After
	public void tearDown() throws Exception {
		prospect = null;
	}

	@Test
	public void testGetUUID() {
		Assert.assertEquals("1", prospect.getUUID());
	}

	@Test
	public void testGetEmail() {
		Assert.assertEquals("firstname.lastname@gmail.com", prospect.getEmail());
	}
	
	@Test
	public void testGetSource() {
		Assert.assertEquals("source", prospect.getSource());
	}
	
	@Test
	public void testGetToken() {
		Assert.assertEquals("token", prospect.getToken());
	}
	
	@Test
	public void testGetCreatedOn() {
		Assert.assertNotNull(prospect.getCreatedOn());
	}
	
	@Test
	public void testGetUpdatedOn() {
		Assert.assertNotNull(prospect.getUpdatedOn());
	}

}
