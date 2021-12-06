package by.lab2.service.validation.impl;

import by.lab2.service.validation.FeatureValidator;

/**
 * IntValidator class.
 * @author Ilja Grigorchik
 */
public class IntValidator implements FeatureValidator {

    /**
     * Method that checks valid of int.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        if (value instanceof Integer) {
            return (Integer) value > 0;
        } else {
            return false;
        }
    }

}
