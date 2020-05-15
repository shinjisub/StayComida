package com.app.staycomida.common;

import java.util.HashMap;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.springframework.core.io.Resource;

public class AbstractConfiguration {
	
	protected Resource [] locations;
	protected HashMap<String, Object> hashMap = null;
	protected CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
	
	public Resource[] getLocations() {
		return locations;
	}
	public void setLocations(Resource[] locations) {
		this.locations = locations;
		System.out.println("AbstarctLocations : "+this.locations);
	}
	
	/**
	 * Configuration Path Mapping 
	 */
	public void loadAbstractConfiguration(){
		for (Resource resource : this.locations) {
			try {
				XMLConfiguration xmlConfiguration = new XMLConfiguration(resource.getFile().getAbsolutePath());
				this.compositeConfiguration.addConfiguration((Configuration) xmlConfiguration);
				System.out.println("resource File mapping Path : "+resource.getFile().getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getString(String xmlParam){
		loadAbstractConfiguration();
		return this.compositeConfiguration.getString(xmlParam);
	}

	public HashMap<String, Object> getHashMap(String xmlParam){
		loadAbstractConfiguration();
		hashMap = new HashMap<String, Object>();
		hashMap.put(xmlParam, this.compositeConfiguration.getString(xmlParam));

		return hashMap;
	}
	
}
