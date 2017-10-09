package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;


public final class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        return new EntityValidator<E>().checkValidity(criteria);
    }

    private Validator() {
    }

}

