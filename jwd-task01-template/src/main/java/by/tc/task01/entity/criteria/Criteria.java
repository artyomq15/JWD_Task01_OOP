package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

    public String getSearchCriteriaClassName() {
        return criteria.keySet().iterator().next().getClass().getName();
    }

    public String getSearchCriteriaSimpleClassName() {
        return criteria.keySet().iterator().next().getClass().getSimpleName();
    }

    public Object getValue(E searchCriteria){
        return criteria.get(searchCriteria);
    }

    public Map<E,Object> getCriteria(){
        return criteria;
    }

}
