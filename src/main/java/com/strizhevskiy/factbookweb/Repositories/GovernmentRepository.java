package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Government;
import org.springframework.data.repository.CrudRepository;

public interface GovernmentRepository extends CrudRepository<Government, Integer> {

    Government findByCountryCodeAndDataYear(String countryCode, int dataYear);
}