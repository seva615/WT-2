package by.lab2.service.validation;

/**
 * CriteriaValidator interface.
 * @author Ilja Grigorchik
 */
public interface FeatureValidator {

    /**
     * Validate value of a search criteria
     *
     * @param value - value to validate
     * @return true, if value is valid. Otherwise, false.
     */
    boolean isCriteriaValid(Object value);
}
