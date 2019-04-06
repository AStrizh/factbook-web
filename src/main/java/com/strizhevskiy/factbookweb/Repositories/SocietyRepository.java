package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Society;
import org.springframework.data.repository.CrudRepository;

public interface SocietyRepository extends CrudRepository<Society, Integer> {

    Society findByCountryCodeAndDataYear(String countryCode, int dataYear);
}