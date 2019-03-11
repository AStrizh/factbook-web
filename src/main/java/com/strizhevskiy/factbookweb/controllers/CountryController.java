package com.strizhevskiy.factbookweb.controllers;

import com.strizhevskiy.factbookweb.Repositories.*;
import com.strizhevskiy.factbookweb.model.CountryMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

    @Autowired
    private CountryMainRepository countryMainRepository;
    @Autowired
    private BorderRepository borderRepository;
    @Autowired
    private CityRepository cityRepository;
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
    private TransnationalRepository transnationalRepository;
    @Autowired
    private TransportationRepository transportationRepository;


    @GetMapping(path="/all")
    public @ResponseBody Iterable<CountryMain> getAllCountries() {
        // This returns a JSON or XML with the countries
        return countryMainRepository.findAll();
    }

    @GetMapping(path="/country") // Map ONLY GET Requests
    public String getCountry (@RequestParam String countryName, Model model) {

        CountryMain country = countryMainRepository.findCountryMainByCountryName(countryName);

        model.addAttribute("countryMain", countryMainRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("geography", geographyRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("society", societyRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("government", governmentRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("economy", economyRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("energy", energyRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("communications", communicationsRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("transportation", transportationRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("military", militaryRepository.findByCountryCode(country.getCountryCode()));
        model.addAttribute("transnational", transnationalRepository.findByCountryCode(country.getCountryCode()));

        model.addAttribute("countryFlag", country.getCountryCode().toLowerCase() + "-lgflag.gif");
        model.addAttribute("countryMap", country.getCountryCode().toLowerCase() + "-map.gif");

        return "country";
    }

    @GetMapping(path = "/allcountries")
    public @ResponseBody Iterable<String> allCountries(){

        return countryMainRepository.listCountries();
    }
}
