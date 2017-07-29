package com.cromey.domain;

import com.cromey.model.Prospect;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This interface lets Spring generate Repository implementation for Prospects.
 */
public interface ProspectsRepository extends MongoRepository<Prospect, String> {

}
