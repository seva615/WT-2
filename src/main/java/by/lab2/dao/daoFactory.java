package by.lab2.dao;

import by.lab2.dao.impl.ApplianceDAOImpl;

/**
 * DAOFactory class.
 * @author Ilja Grigorchik
 */
public final class daoFactory {

    private static final daoFactory instance = new daoFactory();
    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

    /**
     * private constructor
     */
    private daoFactory() {
    }

    /**
     * Gets appliance dao.
     *
     * @return the appliance dao
     */
    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static daoFactory getInstance() {
        return instance;
    }
}
