package by.lab2.service.validation.impl;

import by.lab2.entity.enums.Company;
import by.lab2.service.validation.FeatureValidator;

/**
 * ColorValidator class.
 * @author Ilja Grigorchik
 */
public class CompanyValidator implements FeatureValidator {

    /**
     * Method that checks valid of company.
     *
     * @param value - value to validate
     * @return true or false
     */
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            Company.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}