package com.ivan.springwebapp.repositories;

import com.ivan.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
