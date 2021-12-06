package by.lab2.dao.factory.impl;

import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.dao.factory.ApplianceFactory;
import by.lab2.entity.Appliance;
import by.lab2.entity.Smartphone;
import by.lab2.entity.feature.SearchFeature;
import by.lab2.entity.enums.Color;
import by.lab2.entity.enums.Company;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * TabletPCFactory class.
 * @author Ilja Grigorchik
 */
public class SmartphoneFactory extends ApplianceFactory {
    /**
     * The Price field.
     */
    int price;
    /**
     * The Memory rom field.
     */
    int memoryRom;
    /**
     * The Battery capacity field.
     */
    double batteryCapacity;
    /**
     * The Display inches field.
     */
    double displayInches;
    /**
     * The Color field.
     */
    Color color;
    /**
     * The Company field.
     */
    Company company;


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

                SearchFeature.Smartphone tabletPCSearchCriteria = SearchFeature.Smartphone.valueOf(nodeList.item(i).getNodeName().toUpperCase());

                switch (tabletPCSearchCriteria) {
                    case PRICE:
                        price = Integer.parseInt(value);
                        break;
                    case BATTERY_CAPACITY:
                        batteryCapacity = Double.parseDouble(value);
                        break;
                    case DISPLAY_INCHES:
                        displayInches = Double.parseDouble(value);
                        break;
                    case MEMORY_ROM:
                        memoryRom = Integer.parseInt(value);
                        break;
                    case COLOR:
                        color = Color.valueOf(value);
                        break;
                    case COMPANY:
                        company = Company.valueOf(value);
                        break;
                    default:
                        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
                }
            }
        }
        return new Smartphone(price, batteryCapacity, displayInches, memoryRom, color, company);
    }

}
