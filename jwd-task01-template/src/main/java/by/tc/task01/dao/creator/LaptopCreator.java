package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

import java.util.List;

public class LaptopCreator implements CreatorCommand {
    @Override
    public Appliance execute(List<String> values){
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.parseDouble(values.get(0)));
        laptop.setOperatingSystem(values.get(1));
        laptop.setMemoryRom(Integer.parseInt(values.get(2)));
        laptop.setSystemMemory(Integer.parseInt(values.get(3)));
        laptop.setCentralProcessorUnit(Double.parseDouble(values.get(4)));
        laptop.setDisplayInches(Integer.parseInt(values.get(5)));
        return laptop;
    }
}
