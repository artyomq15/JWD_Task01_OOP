package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;

import java.util.List;

public class OvenCreator implements CreatorCommand{
    @Override
    public Appliance execute(List<String> values){
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.parseInt(values.get(0)));
        oven.setWeight(Double.parseDouble(values.get(1)));
        oven.setCapacity(Integer.parseInt(values.get(2)));
        oven.setDepth(Integer.parseInt(values.get(3)));
        oven.setHeight(Double.parseDouble(values.get(4)));
        oven.setWidth(Double.parseDouble(values.get(5)));
        return oven;
    }
}
