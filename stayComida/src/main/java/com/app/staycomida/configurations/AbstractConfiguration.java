package com.app.staycomida.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.springframework.core.io.Resource;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AbstractConfiguration {
	
	protected Resource [] locations;
	protected HashMap<String, Object> hashMap = null;
	protected CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
	
	public Resource[] getLocations() {
		return locations;
	}
	public void setLocations(Resource[] locations) {
		this.locations = locations;
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
	private static String getTagValue(String tag, Element element) {
		NodeList list = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) list.item(0);
		return nValue.getNodeValue();
	}
	public List getList(String xmlParam){
		loadAbstractConfiguration();
		return this.compositeConfiguration.getList(xmlParam);
	}
	
}
