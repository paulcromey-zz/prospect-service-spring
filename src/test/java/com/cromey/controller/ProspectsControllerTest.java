package com.cromey.controller;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cromey.domain.ProspectsService;
import com.cromey.model.Prospect;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProspectsControllerTest {
	
	private static final MediaType APPLICATION_FORM_URLENCODED = new MediaType(MediaType.APPLICATION_FORM_URLENCODED.getType(),
			MediaType.APPLICATION_FORM_URLENCODED.getSubtype(),
			Charset.forName("utf8")
	);

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
	public void testAddProspect() throws Exception {
		Prospect prospect = new Prospect();
		prospect.setEmail("someone@gmail.com");
		
		when(prospectsService.addProspect(isA(Prospect.class))).then(invocationOnMock -> {
			Prospect saved = (Prospect) invocationOnMock.getArguments()[0];
			saved.setId("id");
			return saved;
		});
		
		mockMvc.perform(post("/api/prospects/")
				.contentType(APPLICATION_FORM_URLENCODED)
				.content(convertObjectToJsonBytes(prospect))).andExpect(status().isCreated());
	}

	@Test
	public void testGetProspects() throws Exception {
		List<Prospect> prospects = Arrays.asList(new Prospect());
		
		when(prospectsService.getProspects()).thenReturn(prospects);
		
		mockMvc.perform(get("/api/prospects/")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetProspect() throws Exception {
		
		Prospect prospect = new Prospect();
		
		when(prospectsService.getProspect("1")).thenReturn(prospect);
		
		mockMvc.perform(get("/api/prospects/{id}", 1)).andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateProspect() throws Exception {

		Prospect prospect = new Prospect();
		prospect.setId("1");
		prospect.setEmail("someone@gmail.com");
		
		when(prospectsService.updateProspect(isA(Prospect.class))).then(invocationOnMock -> {
			Prospect updated = (Prospect) invocationOnMock.getArguments()[0];
			updated.setId("1");
			return updated;
		});
		
		when(prospectsService.updateProspect(prospect)).thenReturn(prospect);
		
		mockMvc.perform(put("/api/prospects/{id}", prospect.getId())
				.contentType(APPLICATION_FORM_URLENCODED)
				.content(convertObjectToJsonBytes(prospect))).andExpect(status().isNoContent());
	}
	
	@Test
	public void testDeleteProspect() throws Exception {
		
		Prospect prospect = new Prospect();
		
		when(prospectsService.getProspect("1")).thenReturn(prospect);
		
		mockMvc.perform(delete("/api/prospects/{id}", 1)).andExpect(status().isNoContent());
	}
	
	@Test
	public void testGetProspectNotFound() throws Exception {
		
		mockMvc.perform(get("/api/prospects/{id}", 1)).andExpect(status().isNotFound());
	}
	
	static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

}
