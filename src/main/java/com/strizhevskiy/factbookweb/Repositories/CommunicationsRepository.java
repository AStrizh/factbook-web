package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Communications;
import org.springframework.data.repository.CrudRepository;

public interface CommunicationsRepository extends CrudRepository<Communications, Integer> {

    Communications findByCountryCode(String countryCode);
}