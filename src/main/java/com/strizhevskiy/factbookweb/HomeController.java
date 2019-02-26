package com.strizhevskiy.factbookweb;

import com.strizhevskiy.factbookweb.model.CountryMain;
import com.strizhevskiy.factbookweb.Repositories.CountryMainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class HomeController {

//    @GetMapping({"","/", "/index", "/index.html"})
//    public String home(){
//        return "home";
//    }

    @Autowired
    private CountryMainRepository countryMainRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CountryMain> getAllCountries() {
        // This returns a JSON or XML with the countries
        return countryMainRepository.findAll();
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewCountry () {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        CountryMain n = new CountryMain();
        n.setCountryName("Fakecountry");
        n.setIntroduction("This is not a real country");
        n.setCountryCode("FK");
        n.setRegion("Fakia");
        countryMainRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/country") // Map ONLY GET Requests
    public @ResponseBody String getCountry (@RequestParam String country) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return countryMainRepository.findCountryMainByCountryName(country)
                                    .getIntroduction()
                                    .replace("\n","<br>");
    }
}
