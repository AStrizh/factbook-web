package com.strizhevskiy.factbookweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Energy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String countryCode;
    private int dataYear;
    private int withoutElectricity;
    private double electrificationPopulationPCT;
    private double electrificationUrbanPCT;
    private double electrificationRuralPCT;
    private int electricityProductionMillionskWh;
    private int electricityConsumptionMillionskWh;
    private int electricityExportsMillionskWh;
    private int electricityImportsMillionskWh;
    private int electricityCapacityThousandskW;
    private double electricityFossilFuelsPCT;
    private double electricityNuclearFuelsPCT;
    private double electricityHydroelectricPlantsPCT;
    private double electricityOtherRenewableSourcesPCT;

    private int oilProductionBarrelsPerDay;
    private int oilExportsBarrelsPerDay;
    private int oilImportsBarrelsPerDay;
    private int oilProvedReservesThousandsBarrels;
    private int refinedPetroleumProductionBarrelsPerDay;
    private int refinedPetroleumConsumptionBarrelsPerDay;
    private int refinedPetroleumExportsBarrelsPerDay;
    private int refinedPetroleumImportsBarrelsPerDay;

    private int naturalGasProductionMillionCubicMeters;
    private int naturalGasConsumptionMillionCubicMeters;
    private int naturalGasExportsMillionCubicMeters;
    private int naturalGasImportsMillionCubicMeters;
    private int naturalGasProvedReservesMillionCubicMeters;
    private int carbonDioxideEmissionsThousandsMetricTons;
}
