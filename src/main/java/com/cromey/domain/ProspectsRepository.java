package com.cromey.domain;

import com.cromey.model.Prospect;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This interface lets Spring generate a whole Repository implementation for
 * Customers.
 */
public interface ProspectsRepository extends MongoRepository<Prospect, String> {

}
