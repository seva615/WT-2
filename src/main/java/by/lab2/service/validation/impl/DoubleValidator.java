package by.lab2.service.validation.impl;

import by.lab2.service.validation.FeatureValidator;

/**
 * DoubleValidator class.
 * @author Ilja Grigorchik
 */
public class DoubleValidator implements FeatureValidator {

    /**
     * Method that checks valid of double.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        if (value instanceof Double) {
            return (Double) value > 0;
        } else {
            return false;
        }
    }

}
