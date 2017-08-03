package com.cromey.controller;

import com.cromey.domain.ProspectsService;
import com.cromey.model.Prospect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller provides the REST methods
 */
@RestController
@RequestMapping("/api/prospects/")
public class ProspectsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Let Spring DI inject the service for us
	@Autowired
	private ProspectsService prospectsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Prospect> getProspects() {
		return prospectsService.getProspects();
	}

}
