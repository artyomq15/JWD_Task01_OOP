package by.tc.task01.service.validation.validator;

import by.tc.task01.service.validation.validator.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceValidatorDirector {
    private Map<String, ApplianceValidator> dispatcher = new HashMap<>();

    {
        dispatcher.put("Laptop", new LaptopValidator());
        dispatcher.put("Oven", new OvenValidator());
        dispatcher.put("Refrigerator", new RefrigeratorValidator());
        dispatcher.put("Speakers", new SpeakersValidator());
        dispatcher.put("TabletPC", new TabletPCValidator());
        dispatcher.put("VacuumCleaner", new VacuumCleanerValidator());
    }

    public ApplianceValidatorDirector(){

    }

    public ApplianceValidator getValidatorCommand(String typeName){
        return dispatcher.get(typeName);
    }
}
