package by.lab2.service.validation;

import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.entity.feature.SearchFeature;
import by.lab2.service.validation.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * CriteriaValidatorFactory class.
 * @author Ilja Grigorchik
 */
public class FeatureValidatorFactory {

    private static final FeatureValidatorFactory instance = new FeatureValidatorFactory();
    private final Map<String, FeatureValidator> validators = new HashMap<>();

    {
        validators.put(SearchFeature.General.NAME.name(), new ApplianceNameValidator());
        validators.put(SearchFeature.General.PRICE.name(), new DoubleValidator());
        validators.put(SearchFeature.PriceFilter.MORE_THAN_CURRENT_PRICE.name(), new DoubleValidator());
        validators.put(SearchFeature.PriceFilter.LESS_THAN_CURRENT_PRICE.name(), new DoubleValidator());
        validators.put(SearchFeature.PriceFilter.EQUAL_CURRENT_PRICE.name(), new DoubleValidator());

        validators.put(SearchFeature.Laptop.BATTERY_CAPACITY.name(), new DoubleValidator());
        validators.put(SearchFeature.Laptop.OS.name(), new OSValidator());
        validators.put(SearchFeature.Laptop.MEMORY_ROM.name(), new DoubleValidator());
        validators.put(SearchFeature.Laptop.CPU.name(), new CPUValidator());
        validators.put(SearchFeature.Laptop.DISPLAY_INCHES.name(), new DoubleValidator());

        validators.put(SearchFeature.Teapot.POWER.name(), new DoubleValidator());
        validators.put(SearchFeature.Teapot.WEIGHT.name(), new DoubleValidator());
        validators.put(SearchFeature.Teapot.BULK.name(), new DoubleValidator());
        validators.put(SearchFeature.Teapot.COLOR.name(), new ColorValidator());

        validators.put(SearchFeature.Mouse.WEIGHT.name(), new DoubleValidator());
        validators.put(SearchFeature.Mouse.LENGTH.name(), new IntValidator());
        validators.put(SearchFeature.Mouse.HEIGHT.name(), new IntValidator());
        validators.put(SearchFeature.Mouse.WIDTH.name(), new IntValidator());
        validators.put(SearchFeature.Mouse.DPI.name(), new IntValidator());


        validators.put(SearchFeature.Smartphone.BATTERY_CAPACITY.name(), new DoubleValidator());
        validators.put(SearchFeature.Smartphone.DISPLAY_INCHES.name(), new DoubleValidator());
        validators.put(SearchFeature.Smartphone.MEMORY_ROM.name(), new DoubleValidator());
        validators.put(SearchFeature.Smartphone.COLOR.name(), new ColorValidator());
        validators.put(SearchFeature.Smartphone.COMPANY.name(), new CompanyValidator());
    }

    /**
     * private constructor
     */
    private FeatureValidatorFactory() {
    }

    /**
     * Gets instance of CriteriaValidatorFactory
     *
     * @return instance instance
     */
    public static FeatureValidatorFactory getInstance() {
        return instance;
    }


    /**
     * Method that gets needed validator.
     *
     * @param criteriaName name
     * @return validator validator
     */
    public FeatureValidator getValidator(String criteriaName) {
        if (validators.containsKey(criteriaName)) {
            return validators.get(criteriaName);
        }
        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
    }

}
