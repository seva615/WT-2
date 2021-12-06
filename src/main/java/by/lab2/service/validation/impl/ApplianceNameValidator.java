package by.lab2.service.validation.impl;

import by.lab2.constants.ApplianceNameConstant;
import by.lab2.service.validation.FeatureValidator;

/**
 * ApplianceNameValidator class.
 * @author Ilja Grigorchik
 */
public class ApplianceNameValidator implements FeatureValidator {

    /**
     * Method that checks valid of criteria name.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            switch ((String) value) {
                case ApplianceNameConstant.LAPTOP:
                case ApplianceNameConstant.TEAPOT:
                case ApplianceNameConstant.SMARTPHONE:
                case ApplianceNameConstant.MOUSE:
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
