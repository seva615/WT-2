package by.lab2.service.validation.impl;

import by.lab2.entity.enums.Color;
import by.lab2.service.validation.FeatureValidator;

/**
 * ColorValidator class.
 * @author Ilja Grigorchik
 */
public class ColorValidator implements FeatureValidator {

    /**
     * Method that checks valid of color.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            Color.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
