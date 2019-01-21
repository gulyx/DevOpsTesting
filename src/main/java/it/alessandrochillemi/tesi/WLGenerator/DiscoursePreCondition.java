package it.alessandrochillemi.tesi.WLGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscoursePreCondition extends PreCondition{
	
	private DiscourseResourceType resourceType;
	
	public DiscoursePreCondition(DiscourseResourceType resourceType, String value) {
		this.resourceType = resourceType;
		this.value = value;
	}
	
	public DiscoursePreCondition(DiscourseResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public DiscourseResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(DiscourseResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public void generatePreConditionValue(String baseURL, String apiUsername, String apiKey){
		if(this.resourceType != null){
			this.value = this.resourceType.generatePreConditionValue(baseURL, apiUsername, apiKey);
		}
	}
	
	public static ArrayList<DiscoursePreCondition> getAllDiscoursePreConditions(String baseURL, String apiUsername, String apiKey){
		ArrayList<DiscoursePreCondition> ret = new ArrayList<DiscoursePreCondition>();
		
		List<DiscourseResourceType> discourseResourceTypeValues = Arrays.asList(DiscourseResourceType.values());
		
		for(DiscourseResourceType discourseResourceType : discourseResourceTypeValues){
			DiscoursePreCondition discoursePreCondition = new DiscoursePreCondition(discourseResourceType,"");
			discoursePreCondition.generatePreConditionValue(baseURL, apiUsername, apiKey);
			ret.add(discoursePreCondition);
		}
		
		return ret;
	}
	
	public void print(){
		System.out.println(resourceType + ": " + value);
	}


}
