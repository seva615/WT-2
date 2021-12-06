package by.lab2.service;

import by.lab2.entity.Appliance;
import by.lab2.entity.feature.Feature;
import by.lab2.exception.ResourceException;
import by.lab2.exception.ServiceException;

import java.util.List;

/**
 * ApplianceService interface of an ApplianceService class.
 * @author Ilja Grigorchik
 */
public interface ApplianceService {

    /**
     * Method that finds list of appliance.
     *
     * @param feature the feature
     * @return the list
     * @throws ResourceException the resource exception
     * @throws ServiceException  the service exception
     */
    List<Appliance> find(Feature feature) throws ResourceException, ServiceException;

}
