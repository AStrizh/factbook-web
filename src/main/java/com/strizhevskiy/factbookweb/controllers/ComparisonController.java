package com.strizhevskiy.factbookweb.controllers;

import com.strizhevskiy.factbookweb.Repositories.*;
import com.strizhevskiy.factbookweb.model.CountriesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComparisonController {

    public static final int DATAYEAR = 2017;

    @Autowired
    private CountryMainRepository countryMainRepository;
    @Autowired
    private CommunicationsRepository communicationsRepository;
    @Autowired
    private EconomyRepository economyRepository;
    @Autowired
    private EnergyRepository energyRepository;
    @Autowired
    private GeographyRepository geographyRepository;
    @Autowired
    private GovernmentRepository governmentRepository;
    @Autowired
    private MilitaryRepository militaryRepository;
    @Autowired
    private SocietyRepository societyRepository;
    @Autowired
    private TransportationRepository transportationRepository;


    @GetMapping("/compare")
    public String compareCountries(@RequestParam("countryNames") List<String> countryNames, Model model){
        CountriesWrapper countriesWrapper = new CountriesWrapper();

        for( String countryName : countryNames){
            String countryCode = countryMainRepository.findCountryMainByCountryNameAndDataYear(countryName, DATAYEAR).getCountryCode();

            countriesWrapper.getCountryMainList().add(countryMainRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getGeographyList().add(geographyRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getSocietyList().add(societyRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getGovernmentList().add(governmentRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getEconomyList().add(economyRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getEnergyList().add(energyRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getCommunicationsList().add(communicationsRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getTransportationList().add(transportationRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));
            countriesWrapper.getMilitaryList().add(militaryRepository.findByCountryCodeAndDataYear(countryCode, DATAYEAR));

        }

        model.addAttribute("wrapper", countriesWrapper);

        return "compare";
    }
}