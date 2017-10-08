package by.tc.task01.service.validation;

import java.util.regex.Pattern;

public final class ValueValidator {
    public static boolean integerValidator(Object value){


        if (value instanceof String &&stringIsNumber(value)){


            return isValidInteger(Integer.parseInt(value.toString().trim()));
        } else {
            return value instanceof Integer && isValidInteger(value);
        }
    }

    private static boolean isValidInteger(Object value){
        return ((Number)value).intValue()>=0;
    }

    public static boolean doubleValidator(Object value){


        if (value instanceof String && stringIsNumber(value)){


            return isValidDouble(Double.parseDouble(value.toString().trim()));
        } else {
            return value instanceof Number && isValidDouble(value);
        }
    }

    private static boolean isValidDouble(Object value){
        return ((Number)value).doubleValue()>=0;
    }

    private static boolean stringIsNumber(Object value){
        if (stringValidator(value)){
            Pattern p = Pattern.compile("^\\-?[0-9]+\\.?[0-9]*");
            return p.matcher(value.toString().trim()).matches();
        }else {
            return false;
        }

    }

    public static boolean rangeValidator(Object value){


        if (value instanceof String ){
            Pattern p = Pattern.compile("^[0-9]+\\.?[0-9]*\\-[0-9]+\\.?[0-9]*");
            return p.matcher(value.toString().trim()).matches();
        } else{
            return false;
        }
    }

    public static boolean stringValidator(Object value){


        if (value instanceof String && value!=null) {
            return true;
        } else {
            return false;
        }
    }

    private ValueValidator(){}
}
