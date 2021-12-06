package by.lab2.service.validation.impl;

import by.lab2.entity.enums.OS;
import by.lab2.service.validation.FeatureValidator;

/**
 * OSValidator class.
 * @author Ilja Grigorchik
 */
public class OSValidator implements FeatureValidator {

    /**
     * Method that checks valid of os.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            OS.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
