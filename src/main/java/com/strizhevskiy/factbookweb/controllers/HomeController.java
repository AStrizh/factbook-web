package com.strizhevskiy.factbookweb.controllers;

import com.strizhevskiy.factbookweb.Repositories.*;
import com.strizhevskiy.factbookweb.model.CountryMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    CountryMainRepository countryMainRepository;

    @GetMapping({"","/", "/index", "/index.html"})
    public String home(Model model){

        Iterable<String> countries = countryMainRepository.listCountries();
        model.addAttribute("countries", countries);

        return "home";
    }


}
