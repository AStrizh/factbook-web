package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Transportation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private int dataYear;
    private int registeredAirCarriers;
    private int airCarriersAircraft;
    private int airCarrierPassengers;
    private long airCarrierFreight;
    private String civilAircraftCode;
    private int totalAirports;
    private int pavedRunways;
    private int pavedOver3047m;
    private int pavedBetween2438TO3047m;
    private int pavedBetween1524TO2437m;
    private int pavedBetween914TO1523m;
    private int pavedUnder914m;
    private int unpavedRunways;
    private int unpavedOver3047m;
    private int unpavedBetween2438TO3047m;
    private int unpavedBetween1524TO2437m;
    private int unpavedBetween914TO1523m;
    private int unpavedUnder914m;
    private int heliports;
    private String pipelines;
    private int totalRailwayKM;
    private int broadGaugeKM;
    private int standardGaugeKM;
    private int narrowGaugeKM;
    private int dualGaugeKM;
    private int totalRoadwaysKM;
    private int pavedRoadwaysKM;
    private int unpavedRoadwaysKM;
    private int waterwaysKM;
    private int merchantMarine;
    private String merchantMarineType;
    private String foreignOwned;
    private String registeredInternationally;
    private String majorSeaport;
    private String riverPort;
    private String oilTerminal;
    private String dryCargoPort;
    private String containerPort;
    private String lNGTerminal;
    private String cruisePort;
}
