package by.lab2.service.validation.impl;

import by.lab2.entity.enums.CPU;
import by.lab2.service.validation.FeatureValidator;

/**
 * CPUValidator class.
 * @author Ilja Grigorchik
 */
public class CPUValidator implements FeatureValidator {

    /**
     * Method that checks valid of cpu.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            CPU.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
