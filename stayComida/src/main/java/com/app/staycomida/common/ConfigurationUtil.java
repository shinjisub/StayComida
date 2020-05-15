package com.app.staycomida.common;

import java.util.HashMap;

public class ConfigurationUtil extends AbstractConfiguration{

	/**
	 * EX) getXmlString("front.superCategory");
	 * @param xmlParam
	 * @return String
	 */
	public String getXmlString(String xmlParam){
		return getString(xmlParam);
	}
	
	/**
	 * EX) getXmlString("front.superCategory");
	 * @param xmlParam
	 * @return HashMap
	 */
	public HashMap<String, Object> getXmlMap(String xmlParam){
		return getHashMap(xmlParam);
	}

	
}
