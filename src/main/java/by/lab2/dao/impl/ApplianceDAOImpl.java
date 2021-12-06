package by.lab2.dao.impl;

import by.lab2.constants.FilenameConstant;
import by.lab2.dao.ApplianceDAO;
import by.lab2.dao.factory.ApplianceFactory;
import by.lab2.entity.Appliance;
import by.lab2.entity.feature.Feature;
import by.lab2.exception.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ApplianceDAOImpl class.
 * @author Ilja Grigorchik
 */
public class ApplianceDAOImpl implements ApplianceDAO {

    /**
     * Method that reads the information from xml file
     */
    @Override
    public List<Appliance> find(Feature feature) throws ResourceException {
        List<Appliance> appliances = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document
                    = documentBuilder.parse(Objects.requireNonNull(getClass().getClassLoader().getResource(FilenameConstant.APPLIANCES_XML)).getFile());
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    ApplianceFactory applianceFactory = ApplianceFactory.getApplianceFactory(node.getNodeName());

                    if (feature.getGroupSearchName().equals(node.getNodeName())) {
                        Appliance appliance = applianceFactory.createAppliance(node.getChildNodes());

                        if (feature.getFeatureMap()
                                .entrySet()
                                .stream()
                                .allMatch(entry -> appliance.isMatchesCriteria(entry.getKey(), entry.getValue()))) {
                            appliances.add(appliance);
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new ResourceException(e);
        }
        return appliances;
    }

}