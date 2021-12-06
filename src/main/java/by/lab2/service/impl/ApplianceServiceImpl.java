package by.lab2.service.impl;

import by.lab2.dao.ExceptionMessageConstant;
import by.lab2.dao.ApplianceDAO;
import by.lab2.dao.daoFactory;
import by.lab2.entity.Appliance;
import by.lab2.entity.feature.Feature;
import by.lab2.exception.ResourceException;
import by.lab2.exception.ServiceException;
import by.lab2.service.ApplianceService;
import by.lab2.service.validation.Validator;

import java.util.List;

/**
 * ApplianceServiceImpl class that works with appliances DAO.
 *
 * @author Ilja Grigorchik
 */
public class ApplianceServiceImpl implements ApplianceService {

    /**
     * Method that find appliances by criteria.
     *
     * @param feature the criteria
     * @return appliances
     * @throws ServiceException exception
     */
    @Override
    public List<Appliance> find(Feature feature) throws ServiceException {
        if (!Validator.isCriteriaValid(feature)) {
            throw new ServiceException(ExceptionMessageConstant.INVALID_CRITERIA_EXCEPTION_MSG);
        }

        List<Appliance> appliances;
        try {
            daoFactory factory = daoFactory.getInstance();
            ApplianceDAO applianceDAO = factory.getApplianceDAO();
            appliances = applianceDAO.find(feature);
        } catch (ResourceException e) {
            throw new ServiceException(e);
        }
        return appliances;
    }

}
