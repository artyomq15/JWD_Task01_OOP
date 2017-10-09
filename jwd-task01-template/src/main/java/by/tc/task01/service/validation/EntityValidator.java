package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static by.tc.task01.service.validation.ValueValidator.*;

public class EntityValidator<E> {
    private Map<String, Predicate<Criteria<E>>> dispatcher = new HashMap<>();

    {
        dispatcher.put("Laptop", laptopValidator());
        dispatcher.put("Oven", ovenValidator());
        dispatcher.put("Refrigerator", refrigeratorValidator());
        dispatcher.put("Speakers", speakersValidator());
        dispatcher.put("TabletPC", tabletPCValidator());
        dispatcher.put("VacuumCleaner", vacuumCleanerValidator());
    }

    private Predicate<Criteria<E>> laptopValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);

                if (searchCriteria.toString().contains("BATTERY_CAPACITY")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("OS")) {
                    result = stringValidator(value);
                } else if (searchCriteria.toString().contains("MEMORY_ROM")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("SYSTEM_MEMORY")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("CPU")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("DISPLAY_INCHS")) {
                    result = integerValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }

            return result;
        };
    }

    private Predicate<Criteria<E>> ovenValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);


                if (searchCriteria.toString().contains("POWER_CONSUMPTION")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("WEIGHT")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("CAPACITY")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("DEPTH")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("HEIGHT")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("WIDTH")) {
                    result = doubleValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }

            return result;
        };
    }

    private Predicate<Criteria<E>> refrigeratorValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);


                if (searchCriteria.toString().contains("POWER_CONSUMPTION")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("WEIGHT")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("FREEZER_CAPACITY")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("OVERALL_CAPACITY")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("HEIGHT")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("WIDTH")) {
                    result = doubleValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }


            return result;
        };
    }

    private Predicate<Criteria<E>> speakersValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);


                if (searchCriteria.toString().contains("POWER_CONSUMPTION")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("NUMBER_OF_SPEAKERS")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("FREQUENCY_RANGE")) {
                    result = rangeValidator(value);
                } else if (searchCriteria.toString().contains("CORD_LENGTH")) {
                    result = integerValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }


            return result;
        };
    }

    private Predicate<Criteria<E>> tabletPCValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);


                if (searchCriteria.toString().contains("BATTERY_CAPACITY")) {
                    result = doubleValidator(value);
                } else if (searchCriteria.toString().contains("DISPLAY_INCHES")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("MEMORY_ROM")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("FLASH_MEMORY_CAPACITY")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("COLOR")) {
                    result = stringValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }

            return result;
        };
    }

    private Predicate<Criteria<E>> vacuumCleanerValidator() {
        return criteria -> {
            boolean result = false;
            for (E searchCriteria : criteria.getCriteria().keySet()) {
                Object value = criteria.getValue(searchCriteria);

                if (searchCriteria.toString().contains("POWER_CONSUMPTION")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("FILTER_TYPE")) {
                    result = stringValidator(value);
                } else if (searchCriteria.toString().contains("BAG_TYPE")) {
                    result = stringValidator(value);
                } else if (searchCriteria.toString().contains("WAND_TYPE")) {
                    result = stringValidator(value);
                } else if (searchCriteria.toString().contains("MOTOR_SPEED_REGULATION")) {
                    result = integerValidator(value);
                } else if (searchCriteria.toString().contains("CLEANING_WIDTH")) {
                    result = integerValidator(value);
                } else {
                    result = false;
                }

                if (!result) {
                    return false;
                }
            }


            return result;
        };
    }

    public boolean checkValidity(Criteria<E> criteria) {
        return dispatcher.get(criteria.getApplianceType()).test(criteria);
    }
}
