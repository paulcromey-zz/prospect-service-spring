package com.cromey.domain;

import com.cromey.model.Prospect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is a little service class we will let Spring inject later.
 */
@Service
public class ProspectsService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProspectsRepository repository;

    public List<Prospect> getProspects() {
    	logger.info("Called getProspects method");
    	List<Prospect> prospects = repository.findAll();
    	logger.info("Prospects: " + prospects);
        return prospects;
    }

}
