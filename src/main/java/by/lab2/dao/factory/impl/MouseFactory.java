package by.lab2.dao.factory.impl;

import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.dao.factory.ApplianceFactory;
import by.lab2.entity.Appliance;
import by.lab2.entity.Mouse;
import by.lab2.entity.feature.SearchFeature;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * SpeakersFactory class.
 * @author Ilja Grigorchik
 */
public class MouseFactory extends ApplianceFactory {
    /**
     * The Price field.
     */
    int price;
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

                SearchFeature.Mouse mouseSearchCriteria
                        = SearchFeature.Mouse.valueOf(nodeList.item(i).getNodeName().toUpperCase());

                switch (mouseSearchCriteria) {
                    case PRICE:
                        price = Integer.parseInt(value);
                        break;
                    case WEIGHT:
                        weight = Double.parseDouble(value);
                        break;
                    case LENGTH:
                        length = Integer.parseInt(value);
                        break;
                    case HEIGHT:
                        height = Integer.parseInt(value);
                        break;
                    case WIDTH:
                        width = Integer.parseInt(value);
                        break;
                    case DPI:
                        dpi = Integer.parseInt(value);
                        break;
                    default:
                        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
                }
            }
        }
        return new Mouse(price, weight, length, height, width, dpi);
    }

}
