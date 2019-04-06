package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Society {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	
    private String countryCode;
    private int dataYear;
    private int population;
    private int Male0_14;
    private int Female0_14;
    private int Male15_24;
    private int Female15_24;
    private int Male25_54;
    private int Female25_54;
    private int Male55_64;
    private int Female55_64;
    private int Male65;
    private int Female65;

    private double youthDependencyRatio;
    private double elderlyDependencyRatio;
    private double potentialSupportRatio;
    private double medianAgeMale;
    private double medianAgeFemale;
    private double populationGrowthRate;
    private double birthRatePer1K;
    private double deathRatePer1K;
    private double netMigrationRate;
    private int urbanPopulation;
    private double urbanizationRate;
    private double motherMeanAgeAtFirstBirth;
    private int maternalMortalityRatePer100K;
    private double infantMaleMortalityRatePer1K;
    private double infantFemaleMortalityRatePer1K;
    private double maleLifeExpectancy;
    private double femaleLifeExpectancy;
    private double childrenBornPerWoman;
    private double contraceptivePrevalencePCT;
    private double healthExpenditurePCT;
    private double physiciansPer1K;
    private double hospitalBedPer1K;

    private double improvedUrbanDrinkingWaterPCT;
    private double improvedRuralDrinkingWaterPCT;
    private double improvedUrbanSanitationFacilityAccessPCT;
    private double improvedRuralSanitationFacilityAccessPCT;
    private double improvedTotalSanitationFacilityAccessPCT;
    private double hIVAIDSPrevalencePCT;
    private int hIVAIDSAfflicted;
    private int hIVAIDSDeaths;
    private String infectiousDiseasesRisk;
    private double adultObesityPCT;
    private double educationExpenditures;
    private double maleLiteracy;
    private double femaleLiteracy;
    private int maleSchoolLifeExpectancy;
    private int femaleSchoolLifeExpectancy;
    private double maleUnemployment;
    private double femaleUnemployment;

    public int totalMale(){
        return (Male0_14 + Male15_24 + Male25_54 + Male55_64 + Male65);
    }

    public int totalFemale(){
        return (Female0_14 + Female15_24 + Female25_54 + Female55_64 + Female65);
    }
}
