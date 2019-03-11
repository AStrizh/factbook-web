package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CountriesWrapper {

    private List<CountryMain> countryMainList;
    private List<Economy> economyList;
    private List<Energy> energyList;
    private List<Geography> geographyList;
    private List<Government> governmentList;
    private List<Transportation> transportationList;
    private List<Communications> communicationsList;
    private List<Society> societyList;
    private List<Military> militaryList;

    public CountriesWrapper(){
        countryMainList = new ArrayList<>();
        communicationsList = new ArrayList<>();
        economyList = new ArrayList<>();
        energyList = new ArrayList<>();
        geographyList = new ArrayList<>();
        governmentList = new ArrayList<>();
        transportationList = new ArrayList<>();
        communicationsList = new ArrayList<>();
        societyList = new ArrayList<>();
        militaryList = new ArrayList<>();
    }
}
