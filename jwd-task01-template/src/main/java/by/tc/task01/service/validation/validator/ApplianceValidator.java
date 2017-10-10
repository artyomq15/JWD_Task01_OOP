package by.tc.task01.service.validation.validator;

import by.tc.task01.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public abstract class ApplianceValidator {
    protected Map<String, Predicate<Object>> dispatcher = new HashMap<>();

    public <E> boolean execute(Criteria<E> criteria) {
        boolean result;
        for (E searchCriteria : criteria.getCriteria().keySet()) {
            Object value = criteria.getValue(searchCriteria);

            result = dispatcher.get(searchCriteria.toString()).test(value);

            if (!result) {
                return false;
            }
        }
        return true;
    }
}
