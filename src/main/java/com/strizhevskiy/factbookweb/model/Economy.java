package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Economy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String countryCode;
    private String overview;
    private double gDPPurchasingPowerParity;
    private double gDPOfficialExchangeRate;
    private double gDPRealGrowthRate;
    private int gDPPerCapita;

    private double grossNationalSaving;
    private double householdConsumption;
    private double governmentConsumption;
    private double investmentFixedCapital;
    private double investmentInventories;
    private double exports;
    private double imports;
    private double gDPAgriculture;
    private double gDPIndustry;
    private double gDPServices;
    private String agricultureProducts;
    private String industries;
    private double industrialGrowth;
    private int laborForce;

    private double occupationAgriculture;
    private double occupationIndustry;
    private double occupationServices;
    private double unemploymentRate;
    private double belowPovertyLine;
    private double lowest10PCTConsumption;
    private double highest10PCTConsumption;
    private double giniIndexIncome;
    private double revenues;
    private double expenditures;
    private double taxes;
    private double budgetSurplus;
    private double publicDebt;
    private String fiscalYear;
    private double inflation;

    private double centralBankDiscount;
    private double commercialBankLending;
    private double narrowMoney;
    private double broadMoney;
    private double domesticCredit;
    private double valueTradedShares;
    private double currentAccountBalance;
    private double exportsTotal;
    private String exportsCommodities;
    private String exportsPartners;
    private double importsTotal;

    private String importsCommodities;
    private String importsPartners;
    private double foreignGoldReserves;
    private double debtExternal;
    private double foreignInvestmentHome;
    private double foreignInvestmentAbroad;
    private String currencyText;
    private double exchangeRate;
}
