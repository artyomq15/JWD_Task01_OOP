package by.tc.task01.dao.creator.impl;

import by.tc.task01.dao.creator.CreatorCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;

import java.util.List;

public class TabletPCCreator implements CreatorCommand {
    @Override
    public Appliance execute(List<String> values){
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.parseDouble(values.get(0)));
        tabletPC.setDisplayInches(Integer.parseInt(values.get(1)));
        tabletPC.setMemoryRom(Integer.parseInt(values.get(2)));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt(values.get(3)));
        tabletPC.setColor(values.get(4));
        return tabletPC;
    }
}
