import by.lab2.constants.ApplianceNameConstant;
import by.lab2.entity.Appliance;
import by.lab2.entity.feature.Feature;
import by.lab2.entity.feature.SearchFeature;
import by.lab2.exception.ResourceException;
import by.lab2.exception.ServiceException;
import by.lab2.service.ApplianceService;
import by.lab2.service.ServiceFactory;
import by.lab2.printer.PrinterAppliance;

import java.util.List;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws ServiceException  the service exception
     * @throws ResourceException the resource exception
     */
    public static void main(String[] args) throws ServiceException, ResourceException {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Feature featureLaptop = new Feature(ApplianceNameConstant.LAPTOP);
        featureLaptop.add(SearchFeature.PriceFilter.LESS_THAN_CURRENT_PRICE.name(), 1000.0);

        appliances = service.find(featureLaptop);

        PrinterAppliance.print(appliances);

        //////////////////////////////////////////////////////////////////

        Feature featureTeapot = new Feature(ApplianceNameConstant.TEAPOT );
        featureTeapot.add(SearchFeature.Teapot.POWER.name(), 800.0);
        featureTeapot.add(SearchFeature.Teapot.BULK.name(), 2.0);

        appliances = service.find(featureTeapot);

        PrinterAppliance.print(appliances);

        //////////////////////////////////////////////////////////////////

        Feature featureSmartphone = new Feature(ApplianceNameConstant.SMARTPHONE);
        featureSmartphone.add(SearchFeature.Smartphone.COLOR.name(), "BLUE");
        featureSmartphone.add(SearchFeature.Smartphone.COMPANY.name(), "APPLE");

        appliances = service.find(featureSmartphone);

        PrinterAppliance.print(appliances);

        //////////////////////////////////////////////////////////////////

        Feature featureMouse = new Feature(ApplianceNameConstant.MOUSE);
        featureMouse.add(SearchFeature.PriceFilter.MORE_THAN_CURRENT_PRICE.name(), 300.0);

        appliances = service.find(featureMouse);

        PrinterAppliance.print(appliances);

    }
}
