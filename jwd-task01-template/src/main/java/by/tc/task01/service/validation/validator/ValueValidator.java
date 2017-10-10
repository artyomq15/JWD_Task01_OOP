package by.tc.task01.service.validation.validator;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class ValueValidator {

    public static Predicate<Object> integerValidator(){
        return value->{
            if (value instanceof String && stringIsNumber(value)) {
                return isValidInteger(Integer.parseInt(value.toString().trim()));
            } else {
                return value instanceof Integer && isValidInteger(value);
            }
        };
    }

    private static boolean isValidInteger(Object value) {
        return ((Number) value).intValue() >= 0;
    }

    public static Predicate<Object> doubleValidator(){
        return value->{
            if (value instanceof String && stringIsNumber(value)) {
                return isValidDouble(Double.parseDouble(value.toString().trim()));
            } else {
                return value instanceof Number && isValidDouble(value);
            }
        };
    }

    private static boolean isValidDouble(Object value) {
        return ((Number) value).doubleValue() >= 0;
    }

    private static boolean stringIsNumber(Object value) {
        if (stringValidator().test(value)) {
            Pattern p = Pattern.compile("^\\-?[0-9]+\\.?[0-9]*");
            return p.matcher(value.toString().trim()).matches();
        } else {
            return false;
        }
    }

    public static Predicate<Object> rangeValidator(){
        return value->{
            if (value instanceof String) {
                Pattern p = Pattern.compile("^[0-9]+\\.?[0-9]*\\-[0-9]+\\.?[0-9]*");
                return p.matcher(value.toString().trim()).matches();
            } else {
                return false;
            }
        };
    }

    public static boolean rangeValidator(Object value) {
        if (value instanceof String) {
            Pattern p = Pattern.compile("^[0-9]+\\.?[0-9]*\\-[0-9]+\\.?[0-9]*");
            return p.matcher(value.toString().trim()).matches();
        } else {
            return false;
        }
    }

    public static Predicate<Object> stringValidator(){
        return value->{
            if (value instanceof String && !value.equals("")) {
                return true;
            } else {
                return false;
            }
        };
    }

    private ValueValidator() {
    }
}
