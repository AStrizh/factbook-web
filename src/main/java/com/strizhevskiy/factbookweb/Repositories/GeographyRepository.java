package com.strizhevskiy.factbookweb.Repositories;

import com.strizhevskiy.factbookweb.model.Geography;
import org.springframework.data.repository.CrudRepository;

public interface GeographyRepository extends CrudRepository<Geography, Integer> {

    Geography findByCountryCode(String countryCode);
}