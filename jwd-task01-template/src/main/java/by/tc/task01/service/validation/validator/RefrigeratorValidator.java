package by.tc.task01.service.validation.validator;

import static by.tc.task01.service.validation.validator.ValueValidator.doubleValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;

public class RefrigeratorValidator extends ApplianceValidator {
    {
        dispatcher.put("POWER_CONSUMPTION", integerValidator());
        dispatcher.put("WEIGHT", doubleValidator());
        dispatcher.put("FREEZER_CAPACITY", integerValidator());
        dispatcher.put("OVERALL_CAPACITY", doubleValidator());
        dispatcher.put("HEIGHT", doubleValidator());
        dispatcher.put("WIDTH", doubleValidator());
    }
}
