package by.lab2.dao.factory.impl;

import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.dao.factory.ApplianceFactory;
import by.lab2.entity.Appliance;
import by.lab2.entity.Laptop;
import by.lab2.entity.feature.SearchFeature;
import by.lab2.entity.enums.CPU;
import by.lab2.entity.enums.OS;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * LaptopFactory class.
 * @author Ilja Grigorchik
 */
public class LaptopFactory extends ApplianceFactory {
    /**
     * The Price field.
     */
    int price;
    /**
     * The Battery capacity field.
     */
    double batteryCapacity;
    /**
     * The Memory rom field.
     */
    double memoryRom;
    /**
     * The Display inches filed.
     */
    double displayInches;
    /**
     * The Cpu field.
     */
    CPU cpu;
    /**
     * The Os field.
     */
    OS os;

    /**
     * Method for create appliance
     *
     * @param nodeList the node list
     * @return appliance {@link Appliance}
     */
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String value = nodeList.item(i).getTextContent();

                SearchFeature.Laptop laptopSearchCriteria = SearchFeature.Laptop.valueOf(nodeList.item(i).getNodeName().toUpperCase());

                switch (laptopSearchCriteria) {
                    case PRICE:
                        price = Integer.parseInt(value);
                        break;
                    case BATTERY_CAPACITY:
                        batteryCapacity = Double.parseDouble(value);
                        break;
                    case OS:
                        os = OS.valueOf(value);
                        break;
                    case MEMORY_ROM:
                        memoryRom = Double.parseDouble(value);
                        break;
                    case CPU:
                        cpu = CPU.valueOf(value);
                        break;
                    case DISPLAY_INCHES:
                        displayInches = Double.parseDouble(value);
                        break;
                    default:
                        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
                }
            }
        }

        return new Laptop(price, batteryCapacity, os, memoryRom, cpu, displayInches);
    }

}
