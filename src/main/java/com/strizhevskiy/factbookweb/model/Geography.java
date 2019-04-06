package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Geography {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private int dataYear;
    private double lat;
    private double lng;
    private double landArea;
    private double waterArea;
    private double landBoundaries;
    private double coastline;
    private double meanElevation;
    private double lowestPointDistance;
    private String lowestPointName;
    private double highestPointDistance;
    private String highestPointName;
    private double irrigatedLand;
}
