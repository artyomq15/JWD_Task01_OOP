package by.tc.task01.service.validation.validator;

import static by.tc.task01.service.validation.validator.ValueValidator.doubleValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;

public class OvenValidator extends ApplianceValidator {
    {
        dispatcher.put("POWER_CONSUMPTION", integerValidator());
        dispatcher.put("WEIGHT", doubleValidator());
        dispatcher.put("CAPACITY", integerValidator());
        dispatcher.put("DEPTH", integerValidator());
        dispatcher.put("HEIGHT", doubleValidator());
        dispatcher.put("WIDTH", doubleValidator());
    }
}
