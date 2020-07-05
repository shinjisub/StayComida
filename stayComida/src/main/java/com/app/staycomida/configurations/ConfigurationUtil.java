package com.app.staycomida.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public List getXmlList(String xmlParam){
		return getList(xmlParam);
	}
}
