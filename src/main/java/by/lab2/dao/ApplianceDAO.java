package by.lab2.dao;

import by.lab2.entity.Appliance;
import by.lab2.entity.feature.Feature;
import by.lab2.exception.ResourceException;

import java.util.List;

/**
 * ApplianceDAO interface of an applianceDao class.
 * @author Ilja Grigorchik
 */
public interface ApplianceDAO {

    /**
     * Finds all appliances by given criteria.
     *
     * @param feature {@link Feature}
     * @return list of appliance
     * @throws ResourceException exception
     */
    List<Appliance> find(Feature feature) throws ResourceException;
}
