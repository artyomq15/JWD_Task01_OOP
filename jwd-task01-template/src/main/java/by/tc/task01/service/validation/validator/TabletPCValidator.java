package by.tc.task01.service.validation.validator;

import static by.tc.task01.service.validation.validator.ValueValidator.doubleValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.stringValidator;

public class TabletPCValidator extends ApplianceValidator {
    {
        dispatcher.put("BATTERY_CAPACITY", doubleValidator());
        dispatcher.put("DISPLAY_INCHES", integerValidator());
        dispatcher.put("MEMORY_ROM", integerValidator());
        dispatcher.put("FLASH_MEMORY_CAPACITY", integerValidator());
        dispatcher.put("COLOR", stringValidator());
    }
}
