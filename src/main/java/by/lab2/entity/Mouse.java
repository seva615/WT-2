package by.lab2.entity;

import by.lab2.constants.ApplianceNameConstant;
import by.lab2.constants.SearchFeatureConstant;

import java.util.Objects;

/**
 * Speakers class entity.
 * @author Ilja Grigorchik
 */
public class Mouse extends Appliance {

    /**
     * The Weight  field.
     */
    double weight;
    /**
     * The Length field.
     */
    int length;
    /**
     * The Height field.
     */
    int height;
    /**
     * The Width field.
     */
    int width;
    /**
     * The DPI field.
     */
    int dpi;

    /**
     * Instantiates a new Speakers.
     */
    public Mouse() {
    }

    /**
     * Instantiates a new Speakers.
     *
     * @param price            the price
     * @param weight           the weight
     * @param length           the length
     * @param height           the height
     * @param width            the width
     * @param dpi              the dpi
     */
    public Mouse(double price, double weight, int length, int height, int width, int dpi ) {
        super(price);
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.dpi = dpi;
    }

    @Override
    public boolean isMatchesCriteria(String criteriaName, Object value) {
        switch (criteriaName) {
            case SearchFeatureConstant.PRICE:
            case SearchFeatureConstant.MORE_THAN_CURRENT_PRICE:
            case SearchFeatureConstant.LESS_THAN_CURRENT_PRICE:
            case SearchFeatureConstant.EQUAL_CURRENT_PRICE:
                return super.isMatchesCriteria(criteriaName, value);
            case SearchFeatureConstant.WEIGHT:
                return (double) value == weight;
            case SearchFeatureConstant.LENGTH:
                return (int) value == length;
            case SearchFeatureConstant.HEIGHT:
                return (int) value == height;
            case SearchFeatureConstant.WIDTH:
                return (int) value == width;
            case SearchFeatureConstant.DPI:
                return (int) value == dpi;
            default:
                return false;
        }
    }

    /**
     * Gets weight value
     *
     * @return weight weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets length value
     *
     * @return length length
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets height value
     *
     * @return height height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets width value
     *
     * @return width width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets dpi value
     *
     * @return dpi dpi
     */
    public int getDpi() {
        return dpi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mouse mouse = (Mouse) o;
        return Double.compare(mouse.weight, weight) == 0 && length == mouse.length && height == mouse.height && width == mouse.width && dpi == mouse.dpi ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, length, height, width, dpi);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "weight=" + weight +
                ", length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", dpi=" + dpi +
                '}';
    }
}
