package by.lab2.entity;

import by.lab2.constants.SearchFeatureConstant;

import java.io.Serializable;
import java.util.Objects;

/**
 * Appliance class.
 * @author Ilja Grigorchik
 */
public class Appliance implements Serializable {

    /**
     * Field price - price of appliance
     */
    private double price;

    /**
     * Instantiates a new Appliance.
     */
    public Appliance() {
    }

    /**
     * Instantiates a new Appliance.
     *
     * @param price the price
     */
    public Appliance(double price) {
        this.price = price;
    }

    /**
     * Is matches criteria boolean.
     *
     * @param criteriaName the criteria name
     * @param value        the value
     * @return the boolean
     */
    public boolean isMatchesCriteria(String criteriaName, Object value) {
        switch (criteriaName) {
            case SearchFeatureConstant.MORE_THAN_CURRENT_PRICE:
                return price > (double) value;
            case SearchFeatureConstant.LESS_THAN_CURRENT_PRICE:
                return price < (double) value;
            case SearchFeatureConstant.PRICE:
            case SearchFeatureConstant.EQUAL_CURRENT_PRICE:
                return price == (double) value;
            default:
                return false;
        }
    }

    /**
     * Gets price value
     *
     * @return price price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return Double.compare(appliance.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "price=" + price +
                '}';
    }
}
