package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Military {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private int dataYear;
    private double militaryExpenditure;
    private String militaryObligation;
    private String militaryBranches;
}
