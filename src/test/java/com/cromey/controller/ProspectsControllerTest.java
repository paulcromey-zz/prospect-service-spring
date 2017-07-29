package com.cromey.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.cromey.domain.ProspectsService;
import com.cromey.model.Prospect;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProspectsControllerTest {

	@InjectMocks
	ProspectsController prospectsController;

	@Mock
	ProspectsService prospectsService;

	@Mock
	View mockView;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(prospectsController).setSingleView(mockView).build();
	}

	@After
	public void tearDown() throws Exception {
		prospectsController = null;
	}

	@Test
	public void testGetCustomers() throws Exception {
		List<Prospect> prospects = Arrays.asList(new Prospect());
		when(prospectsService.getProspects()).thenReturn(prospects);
		mockMvc.perform(get("/api/prospects/")).andExpect(status().isOk());
		Assert.assertEquals(1, prospects.size());
	}

}
