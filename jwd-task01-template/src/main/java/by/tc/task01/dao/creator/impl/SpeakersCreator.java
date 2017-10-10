package by.tc.task01.dao.creator.impl;

import by.tc.task01.dao.creator.CreatorCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

import java.util.List;

public class SpeakersCreator implements CreatorCommand {
    @Override
    public Appliance execute(List<String> values){
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.parseInt(values.get(0)));
        speakers.setNumberOfSpeakers(Integer.parseInt(values.get(1)));
        speakers.setFrequencyRange(values.get(2));
        speakers.setCordLength(Integer.parseInt(values.get(3)));

        return speakers;
    }
}
