package by.tc.task01.service.validation.validator;

import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.rangeValidator;

public class SpeakersValidator extends ApplianceValidator {
    {
        dispatcher.put("POWER_CONSUMPTION", integerValidator());
        dispatcher.put("NUMBER_OF_SPEAKERS", integerValidator());
        dispatcher.put("FREQUENCY_RANGE", rangeValidator());
        dispatcher.put("CORD_LENGTH", integerValidator());
    }
}
