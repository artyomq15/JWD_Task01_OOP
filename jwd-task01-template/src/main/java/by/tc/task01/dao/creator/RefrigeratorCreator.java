package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;

import java.util.List;

public class RefrigeratorCreator implements CreatorCommand {
    @Override
    public Appliance execute(List<String> values){
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.parseInt(values.get(0)));
        refrigerator.setWeight(Double.parseDouble(values.get(1)));
        refrigerator.setFreezerCapacity(Integer.parseInt(values.get(2)));
        refrigerator.setOverallCapacity(Double.parseDouble(values.get(3)));
        refrigerator.setHeight(Double.parseDouble(values.get(4)));
        refrigerator.setWidth(Double.parseDouble(values.get(5)));
        return refrigerator;
    }
}
