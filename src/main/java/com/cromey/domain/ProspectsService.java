package com.cromey.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cromey.model.Prospect;

/**
 * This is a little service class we will let Spring inject later.
 */
@Service
public class ProspectsService {
	
	@Autowired
	private ProspectsRepository repository;

	public Prospect addProspect(Prospect prospect) {
		return repository.save(prospect);
	}
	
	public List<Prospect> getProspects() {
		return repository.findAll();
	}

	public Prospect getProspect(String id) {
		return repository.findOne(id);
	}
	
	public Prospect updateProspect(Prospect prospect) {
		return repository.save(prospect);
	}
	
	public Prospect deleteProspect(Prospect prospect) {
		repository.delete(prospect);
		return prospect;
	}
	
}
