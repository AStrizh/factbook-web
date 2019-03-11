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
            String countryCode = countryMainRepository.findCountryMainByCountryName(countryName).getCountryCode();

            countriesWrapper.getCountryMainList().add(countryMainRepository.findByCountryCode(countryCode));
            countriesWrapper.getGeographyList().add(geographyRepository.findByCountryCode(countryCode));
            countriesWrapper.getSocietyList().add(societyRepository.findByCountryCode(countryCode));
            countriesWrapper.getGovernmentList().add(governmentRepository.findByCountryCode(countryCode));
            countriesWrapper.getEconomyList().add(economyRepository.findByCountryCode(countryCode));
            countriesWrapper.getEnergyList().add(energyRepository.findByCountryCode(countryCode));
            countriesWrapper.getCommunicationsList().add(communicationsRepository.findByCountryCode(countryCode));
            countriesWrapper.getTransportationList().add(transportationRepository.findByCountryCode(countryCode));
            countriesWrapper.getMilitaryList().add(militaryRepository.findByCountryCode(countryCode));
        }

        model.addAttribute("wrapper", countriesWrapper);

        return "compare";
    }
}