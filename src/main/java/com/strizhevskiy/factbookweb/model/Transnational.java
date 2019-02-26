package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Transnational {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private String disputes;
    private String refugees;
    private String iDPs;
    private String statelessPersons;
    private String traffickingSituation;
    private String traffickingTierRating;
    private String illicitDrugs;
}
