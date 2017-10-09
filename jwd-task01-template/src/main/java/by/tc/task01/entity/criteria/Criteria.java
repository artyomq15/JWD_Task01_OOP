package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

    private String applianceType;

    private Map<E, Object> criteria = new HashMap<E, Object>();

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

    public Object getValue(E searchCriteria){
        return criteria.get(searchCriteria);
    }

    public Map<E,Object> getCriteria(){
        return criteria;
    }

}
