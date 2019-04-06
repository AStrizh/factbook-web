package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Communications {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String countryCode;
    private int dataYear;
    private int totalFixedLines;
    private int fixedLinesPer100;
    private int totalCellular;
    private int cellularPer100;
    private String telephoneGeneralAssessment;
    private String telephoneSystemDomestic;
    private String telephoneSystemInternational;
    private String broadcastMedia;
    private String internetCode;
    private int internetUsers;
    private double internetUsersPCT;
}
