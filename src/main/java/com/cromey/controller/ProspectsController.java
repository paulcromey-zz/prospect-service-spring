package com.cromey.controller;

import com.cromey.domain.ProspectsService;
import com.cromey.model.Prospect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.mockito.Matchers.isNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

/**
 * This controller provides the REST methods
 */
@RestController
@RequestMapping("/api/prospects")
public class ProspectsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final DateTimeFormatter dtf = DateTimeFormatter
			.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	// Let Spring DI inject the service for us
	@Autowired
	private ProspectsService prospectsService;
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded"})
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Prospect addProspect(Prospect prospect){
		prospect.setUUID(UUID.randomUUID().toString());
		prospect.setCreatedOn(LocalDateTime.now().format(dtf));
		prospect.setUpdatedOn(LocalDateTime.now().format(dtf));
		return prospectsService.addProspect(prospect);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Prospect> getProspects() {
		return prospectsService.getProspects();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Prospect getProspect(@PathVariable("id") String id) {
		Prospect prospect = prospectsService.getProspect(id);
		if(Objects.isNull(prospect))
			throw new ProspectNotFoundException();
		return prospectsService.getProspect(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Prospect deleteProspect(@PathVariable("id") String id) {
		return prospectsService.deleteProspect(id);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Prospect")
	public class ProspectNotFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	     
	}

}
