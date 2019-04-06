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

    public static final int DATAYEAR = 2017;

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

        CountryMain country = countryMainRepository.findCountryMainByCountryNameAndDataYear(countryName, DATAYEAR);

        model.addAttribute("countryMain", countryMainRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("geography", geographyRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("society", societyRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("government", governmentRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("economy", economyRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("energy", energyRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("communications", communicationsRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("transportation", transportationRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("military", militaryRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));
        model.addAttribute("transnational", transnationalRepository.findByCountryCodeAndDataYear(country.getCountryCode(), DATAYEAR));

        model.addAttribute("countryFlag", country.getCountryCode().toLowerCase() + "-lgflag.gif");
        model.addAttribute("countryMap", country.getCountryCode().toLowerCase() + "-map.gif");

        return "country";
    }

    @GetMapping(path = "/allcountries")
    public @ResponseBody Iterable<String> allCountries(){

        return countryMainRepository.listCountries();
    }
}
