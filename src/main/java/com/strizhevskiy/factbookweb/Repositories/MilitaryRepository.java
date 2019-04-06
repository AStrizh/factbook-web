package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Military;
import org.springframework.data.repository.CrudRepository;

public interface MilitaryRepository extends CrudRepository<Military, Integer> {

    Military findByCountryCodeAndDataYear(String countryCode, int dataYear);
}