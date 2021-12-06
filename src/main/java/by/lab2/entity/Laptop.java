package by.lab2.entity;

import by.lab2.constants.ApplianceNameConstant;
import by.lab2.constants.SearchFeatureConstant;
import by.lab2.entity.enums.CPU;
import by.lab2.entity.enums.OS;

import java.util.Objects;

/**
 * Laptop class entity.
 *
 * @author Ilja Grigorchik
 */
public class Laptop extends Appliance {

    /**
     * batteryCapacity field
     */
    private double batteryCapacity;
    /**
     * memoryRom field
     */
    private double memoryRom;
    /**
     * displayInches field
     */
    private double displayInches;
    /**
     * os field
     */
    private OS os;
    /**
     * cpu field
     */
    private CPU cpu;

    /**
     * Instantiates a new Laptop.
     */
    public Laptop() {
    }

    /**
     * Instantiates a new Laptop.
     *
     * @param price           the price
     * @param batteryCapacity the battery capacity
     * @param os              the os
     * @param memoryRom       the memory rom
     * @param cpu             the cpu
     * @param displayInches   the display inches
     */
    public Laptop(double price, double batteryCapacity, OS os, double memoryRom, CPU cpu, double displayInches) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.cpu = cpu;
        this.displayInches = displayInches;
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
                return ApplianceNameConstant.LAPTOP.equals(value);
            case SearchFeatureConstant.BATTERY_CAPACITY:
                return (double) value == batteryCapacity;
            case SearchFeatureConstant.OS:
                return os.equals(OS.valueOf((String) value));
            case SearchFeatureConstant.MEMORY_ROM:
                return (double) value == memoryRom;
            case SearchFeatureConstant.CPU:
                return cpu.equals(CPU.valueOf((String) value));
            case SearchFeatureConstant.DISPLAY_INCHES:
                return (double) value == displayInches;
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
     * Gets OS value
     *
     * @return os os
     */
    public OS getOs() {
        return os;
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
     * Gets cpu value
     *
     * @return cpu cpu
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Gets displayInches value
     *
     * @return displayInches display inches
     */
    public double getDisplayInches() {
        return displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return batteryCapacity == laptop.batteryCapacity
                && memoryRom == laptop.memoryRom
                && Double.compare(laptop.displayInches, displayInches) == 0
                && os == laptop.os
                && cpu == laptop.cpu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, os, memoryRom, cpu, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + super.getPrice() +
                ", batteryCapacity=" + batteryCapacity +
                ", os=" + os +
                ", memoryRom=" + memoryRom +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }
}
