package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.director.ApplianceValidatorDirector;
import by.tc.task01.service.validation.validator.ApplianceValidator;


public final class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        ApplianceValidatorDirector applianceValidatorDirector = new ApplianceValidatorDirector();
        ApplianceValidator applianceValidator = applianceValidatorDirector.getValidatorCommand(criteria.getApplianceType());

        return applianceValidator.execute(criteria);
    }

    private Validator() {
    }

}

