package by.tc.task01.service.validation.validator;

import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.stringValidator;

public class VacuumCleanerValidator extends ApplianceValidator {
    {
        dispatcher.put("POWER_CONSUMPTION", integerValidator());
        dispatcher.put("FILTER_TYPE", stringValidator());
        dispatcher.put("BAG_TYPE", stringValidator());
        dispatcher.put("WAND_TYPE", stringValidator());
        dispatcher.put("MOTOR_SPEED_REGULATION", integerValidator());
        dispatcher.put("CLEANING_WIDTH", integerValidator());
    }
}
