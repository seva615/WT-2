package by.lab2.entity.feature;

import java.util.HashMap;
import java.util.Map;

/**
 * Criteria class.
 * @author Ilja Grigorchik
 */
public class Feature {
    /**
     * Field featureMap contains SearchFeature for further filtering
     */
    private final Map<String, Object> featureMap = new HashMap<>();
    /**
     * Field groupSearchName
     */
    private final String groupSearchName;

    /**
     * Feature constructor - creating a new Feature object with parameters
     *
     * @param groupSearchName - group search name
     */
    public Feature(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    /**
     * Gets groupSearchName
     *
     * @return groupSearchName group search name
     */
    public String getGroupSearchName() {
        return groupSearchName;
    }

    /**
     * Gets featureMap
     *
     * @return featureMap feature map
     */
    public Map<String, Object> getFeatureMap() {
        return featureMap;
    }

    /**
     * Adds new SearchCriteria with value to criteriaMap
     *
     * @param searchFeature the search criteria
     * @param value          the value
     */
    public void add(String searchFeature, Object value) {
        featureMap.put(searchFeature, value);
    }
}
