package by.tc.task01.dao.director;

import by.tc.task01.dao.creator.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {
    private Map<String, CreatorCommand> dispatcher = new HashMap<>();

    {
        dispatcher.put("Laptop", new LaptopCreator());
        dispatcher.put("Oven", new OvenCreator());
        dispatcher.put("Refrigerator", new RefrigeratorCreator());
        dispatcher.put("Speakers", new SpeakersCreator());
        dispatcher.put("TabletPC", new TabletPCCreator());
        dispatcher.put("VacuumCleaner", new VacuumCleanerCreator());
    }

    public ApplianceDirector(){

    }

    public CreatorCommand getCreatorCommand(String typeName){
        return dispatcher.get(typeName);
    }

}
