package by.tc.task01.dao.creator.impl;

import by.tc.task01.dao.creator.CreatorCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

import java.util.List;


public class VacuumCleanerCreator implements CreatorCommand {
    @Override
    public Appliance execute(List<String> values){
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.parseInt(values.get(0)));
        vacuumCleaner.setFilterType(values.get(1));
        vacuumCleaner.setBagType(values.get(2));
        vacuumCleaner.setWandType(values.get(3));
        vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(values.get(4)));
        vacuumCleaner.setCleaningWidth(Integer.parseInt(values.get(5)));
        return vacuumCleaner;
    }
}
