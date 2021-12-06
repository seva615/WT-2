package by.lab2.entity.feature;

/**
 * SearchFeature class.
 * Contains all search feuture.
 * @author Ilja Grigorchik
 */
public final class SearchFeature {

    /**
     * Contains General search feature
     */
    public enum General {
        NAME, PRICE
    }

    /**
     * Contains Teapot search feature
     */
    public enum Teapot {
        PRICE, POWER, WEIGHT, BULK, COLOR
    }

    /**
     * Contains Laptop search feature
     */
    public enum Laptop {
        PRICE, BATTERY_CAPACITY, OS, MEMORY_ROM, CPU, DISPLAY_INCHES
    }


    /**
     * Contains Smartphone search feature
     */
    public enum Smartphone {
        PRICE, BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, COLOR, COMPANY
    }

    /**
     * Contains Speakers search feature
     */
    public enum Mouse {
        PRICE, WEIGHT, LENGTH, HEIGHT, WIDTH, DPI
    }

    /**
     * Contains PriceFilter search feature
     */
    public enum PriceFilter {
        MORE_THAN_CURRENT_PRICE, LESS_THAN_CURRENT_PRICE, EQUAL_CURRENT_PRICE
    }

    /**
     * Private constructor.
     */
    private SearchFeature() {
    }
}

