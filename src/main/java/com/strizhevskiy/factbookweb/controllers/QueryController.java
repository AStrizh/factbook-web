package com.strizhevskiy.factbookweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class QueryController {

    public static final int DATAYEAR = 2017;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/queryBuilder")
    public String queryBuilder(){

        return "querybuilder";
    }


    //TODO: Create group by option (region, year)
    //TODO: Add year selection option / option to select multiple years

    //TODO: Create aggregate functions on columns for things like male/female population
    //TODO: Check for missing data in SQL (urban population)



    @GetMapping("/queryResponse")
    public String createQuery(@RequestParam("params") List<String> params, @RequestParam List<String> sqlWhereList,
                              @RequestParam List<String> comparison, @RequestParam List<String> filtervalue,
                              Model model){

        StringBuilder sb = new StringBuilder();

        //String requested = "SELECT CountryMain.CountryName, Society.Population, Economy.GDPOfficialExchangeRate, Economy.GDPPerCapita, Communications.CellularPer100\n";

        String requested = "SELECT ";
        for(int i = 0; i < params.size(); i++){
            if(i+1 < params.size())
                requested += params.get(i) + ", ";
            else
                requested += params.get(i) + "\n";
        }


        String joins = "FROM CountryMain\n" +
                "LEFT JOIN Geography ON CountryMain.CountryCode = Geography.CountryCode \n" +
                "LEFT JOIN Society ON CountryMain.CountryCode = Society.CountryCode \n" +
                "LEFT JOIN Government ON CountryMain.CountryCode = Government.CountryCode \n" +
                "LEFT JOIN Economy ON CountryMain.CountryCode = Economy.CountryCode \n" +
                "LEFT JOIN Energy ON CountryMain.CountryCode = Energy.CountryCode \n" +
                "LEFT JOIN Communications ON CountryMain.CountryCode = Communications.CountryCode \n" +
                "LEFT JOIN Transportation ON CountryMain.CountryCode = Transportation.CountryCode \n" +
                "LEFT JOIN Military ON CountryMain.CountryCode = Military.CountryCode \n" +
                "LEFT JOIN Transnational ON CountryMain.CountryCode = Transnational.CountryCode \n";

        //String conditions = "WHERE CountryMain.Region = \"Europe\" AND Society.Population > 10000000\n";
        //String conditions = "WHERE " + sqlWhereList.get(0) + " " + comparison.get(0) + " " + filtervalue.get(0)  + " \n";


//        String conditions = "WHERE ";
//        for(int i = 0; i < sqlWhereList.size(); i++){
//
//            if(i+1 < sqlWhereList.size())
//                conditions += sqlWhereList.get(i) + " " + comparison.get(i) + " " + filtervalue.get(i) + " "+ ", ";
//            else
//                conditions += sqlWhereList.get(i) + "\n";
//
//        }



        String year = String.format("WHERE CountryMain.DataYear = %1$s AND Geography.DataYear = %1$s AND Society.DataYear = %1$s AND Government.DataYear = %1$s\n" +
                "AND Economy.DataYear = %1$s AND Energy.DataYear = %1$s AND Communications.DataYear = %1$s AND Transportation.DataYear = %1$s\n" +
                "AND Military.DataYear = %1$s AND Transnational.DataYear = %1$s\n", DATAYEAR);


        if(filtervalue.isEmpty()){
            System.out.println("Filter is empty");
        }

        else if(filtervalue.equals("")){
            System.out.println("Filter is empty string");
        }

        else {
            System.out.println("Cant say anything about filter value");
        }

        String conditions = "";
        if(!filtervalue.isEmpty()){

            for(int i = 0; i < sqlWhereList.size(); i++){

                conditions += "AND " + sqlWhereList.get(i) + " " + comparison.get(i) + " " + filtervalue.get(i) + " " + "\n";

            }
        }


        String ordering = "ORDER BY CountryMain.CountryName";


        sb.append(requested);
        sb.append(joins);
        sb.append(year);
        sb.append(conditions);
        sb.append(ordering);

        String query = sb.toString();
        System.out.println(query);

        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();

        List<String> categories = new ArrayList<>();
        for(String param : params){
            categories.add(param.split("\\.")[1]);  //param.split(".")[1]
        }


//        for(String category : categories)
//            System.out.println(category);
//
//        System.out.println();
//
//        for( Object[] result : results){
//            for(Object subResult : result)
//                 System.out.print(subResult + " ");
//            System.out.println("\n");
//        }


        model.addAttribute("results", results);
        model.addAttribute("categories", categories);


        return "queryResponse";
    }
}
