package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AdminNavigation {

	private List<HashMap<String, Object>> navList = new ArrayList<HashMap<String, Object>>();

	private static String getTagValue(String tag, Element element) {
		NodeList list = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) list.item(0);
		return nValue.getNodeValue();
	}

	public void setNav() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("/resources/xml/admin-navigation.xml");
			doc.getDocumentElement().normalize();

			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			NodeList list = doc.getElementsByTagName("navlist");
			System.out.println("-----------------------");

			for (int temp = 0; temp < list.getLength(); temp++) {
				Node node = list.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("First Name : " + getTagValue("firstname", element));
					System.out.println("Last Name : " + getTagValue("lastname", element));
					System.out.println("Nick Name : " + getTagValue("nickname", element));
					System.out.println("Salary : " + getTagValue("salary", element));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
