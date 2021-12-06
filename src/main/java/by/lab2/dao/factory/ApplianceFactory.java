package by.lab2.dao.factory;

import by.lab2.constants.ApplianceNameConstant;
import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.dao.factory.impl.LaptopFactory;
import by.lab2.dao.factory.impl.SmartphoneFactory;
import by.lab2.dao.factory.impl.MouseFactory;
import by.lab2.dao.factory.impl.TeapotFactory;
import by.lab2.entity.Appliance;
import org.w3c.dom.NodeList;

/**
 * ApplianceFactory abstract class.
 *
 * @author Ilja Grigorchik
 */
public abstract class ApplianceFactory {

    /**
     * Create appliance appliance.
     *
     * @param nodeList the node list
     * @return the appliance
     */
    public abstract Appliance createAppliance(NodeList nodeList);

    /**
     * Gets appliance factory.
     *
     * @param applianceName the appliance name
     * @return the appliance factory
     */
    public static ApplianceFactory getApplianceFactory(String applianceName) {
        switch (applianceName) {
            case ApplianceNameConstant.LAPTOP:
                return new LaptopFactory();
            case ApplianceNameConstant.TEAPOT:
                return new TeapotFactory();
            case ApplianceNameConstant.MOUSE:
                return new MouseFactory();
            case ApplianceNameConstant.SMARTPHONE:
                return new SmartphoneFactory();
            default:
                throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_FACTORY_EXCEPTION_MSG);
        }
    }

}
