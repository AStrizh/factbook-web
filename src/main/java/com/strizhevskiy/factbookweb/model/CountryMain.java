package com.strizhevskiy.factbookweb.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CountryMain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String countryCode;
    private String countryName;
    private String region;
    private String introduction;


//    public String getCountryCode() {
//        return countryCode;
//    }
//
//    public void setCountryCode(String countryCode) {
//        this.countryCode = countryCode;
//    }
//
//    public String getCountryName() {
//        return countryName;
//    }
//
//    public void setCountryName(String countryName) {
//        this.countryName = countryName;
//    }
//
//    public String getRegion() {
//        return region;
//    }
//
//    public void setRegion(String region) {
//        this.region = region;
//    }
//
//    public String getIntroduction() {
//        return introduction;
//    }
//
//    public void setIntroduction(String introduction) {
//        this.introduction = introduction;
//    }
}
