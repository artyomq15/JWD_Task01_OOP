package by.tc.task01.service.validation.validator;


import static by.tc.task01.service.validation.validator.ValueValidator.doubleValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.integerValidator;
import static by.tc.task01.service.validation.validator.ValueValidator.stringValidator;

public class LaptopValidator extends ApplianceValidator {
    {
        dispatcher.put("BATTERY_CAPACITY", doubleValidator());
        dispatcher.put("OS", stringValidator());
        dispatcher.put("MEMORY_ROM", integerValidator());
        dispatcher.put("SYSTEM_MEMORY", integerValidator());
        dispatcher.put("CPU", doubleValidator());
        dispatcher.put("DISPLAY_INCHS", integerValidator());
    }
}
