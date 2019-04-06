package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Transnational;
import org.springframework.data.repository.CrudRepository;

public interface TransnationalRepository extends CrudRepository<Transnational, Integer> {

    Transnational findByCountryCodeAndDataYear(String countryCode, int dataYear);
}