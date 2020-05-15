package com.app.staycomida.configurations;

import java.util.HashMap;
import java.util.List;

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

	/**
	 * EX) getXmlList("front.superCategory");
	 * @param xmlParam
	 * @return List
	 */
	/*
	 * ※ Don't use 사용금지
	public List getXmlList(String xmlParam){
		return getList(xmlParam);
	}
	*/
}
