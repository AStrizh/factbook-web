package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Government {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private String governmentType;
    private double capitalLat;
    private double capitalLng;
    private String timeDifference;
    private String daylightSavingTime;
    private String independenceDate;
    private String nationalHoliday;
    private String legalSystem;
    private Boolean citizenshipByBirth;

    private String citizenshipByDescent;
    private Boolean dualCitizenship;
    private String naturalization;
    private String suffrageAge;
    private Boolean suffrageCompulsory;
    private String chiefOfState;
    private String headOfGovernment;
    private String diplomatToUS;
    private String diplomatFromUS;
}