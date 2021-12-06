package by.lab2.entity;

import by.lab2.constants.ApplianceNameConstant;
import by.lab2.constants.SearchFeatureConstant;
import by.lab2.entity.enums.Color;
import by.lab2.entity.enums.Company;

import java.util.Objects;

/**
 * Smartphone class entity.
 * @author Ilja Grigorchik
 */
public class Smartphone extends Appliance {
    /**
     * Field batteryCapacity of smartphone
     */
    private double batteryCapacity;
    /**
     * Field displayInches of smartphone
     */
    private double displayInches;
    /**
     * Field memoryRom of smartphone
     */
    private double memoryRom;
    /**
     * Field color of smartphone
     */
    private Color color;
    /**
     * Field company of smartphone
     */
    private Company company;
    /**
     * Instantiates a new Tablet pc.
     */
    public Smartphone() {
    }

    /**
     * Instantiates a new Tablet pc.
     *
     * @param price               the price
     * @param batteryCapacity     the battery capacity
     * @param displayInches       the display inches
     * @param memoryRom           the memory rom
     * @param color               the color
     * @param company             the company
     */
    public Smartphone(double price,
                    double batteryCapacity,
                    double displayInches,
                    double memoryRom,
                    Color color,
                    Company company) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.color = color;
        this.company = company;
    }

    @Override
    public boolean isMatchesCriteria(String criteriaName, Object value) {
        switch (criteriaName) {
            case SearchFeatureConstant.PRICE:
            case SearchFeatureConstant.MORE_THAN_CURRENT_PRICE:
            case SearchFeatureConstant.LESS_THAN_CURRENT_PRICE:
            case SearchFeatureConstant.EQUAL_CURRENT_PRICE:
                return super.isMatchesCriteria(criteriaName, value);
            case SearchFeatureConstant.APPLIANCE_NAME:
                return ApplianceNameConstant.SMARTPHONE.equals(value);
            case SearchFeatureConstant.BATTERY_CAPACITY:
                return (double) value == batteryCapacity;
            case SearchFeatureConstant.DISPLAY_INCHES:
                return (double) value == displayInches;
            case SearchFeatureConstant.MEMORY_ROM:
                return (double) value == memoryRom;
            case SearchFeatureConstant.COLOR:
                return color.equals(Color.valueOf((String) value));
            case SearchFeatureConstant.COMPANY:
                return company.equals(Company.valueOf((String) value));
            default:
                return false;
        }
    }

    /**
     * Gets batteryCapacity value
     *
     * @return batteryCapacity battery capacity
     */
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * Gets displayInches value
     *
     * @return displayInches display inches
     */
    public double getDisplayInches() {
        return displayInches;
    }

    /**
     * Gets memoryRom value
     *
     * @return memoryRom memory rom
     */
    public double getMemoryRom() {
        return memoryRom;
    }

    /**
     * Gets color value
     *
     * @return color color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets company value
     *
     * @return company company
     */
    public Company getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Double.compare(smartphone.batteryCapacity, batteryCapacity) == 0 && Double.compare(smartphone.displayInches, displayInches) == 0 && memoryRom == smartphone.memoryRom  && color == smartphone.color && company == smartphone.company;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, displayInches, memoryRom, color, company);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "price=" + super.getPrice() +
                ", batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", color=" + color +
                ", company=" + company +
                '}';
    }
}
