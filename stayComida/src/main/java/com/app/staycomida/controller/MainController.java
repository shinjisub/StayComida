package com.app.staycomida.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.staycomida.common.CommonUtil;
import com.app.staycomida.common.StringUtil;
import com.app.staycomida.common.UploadUtil;
import com.app.staycomida.configurations.ConfigurationUtil;
import com.app.staycomidaService.StayComidaServiceImpl;

@Controller
public class MainController {

	@Autowired
	private StayComidaServiceImpl stayComidaServiceImpl;
	
	@Resource(name="uploadUtil")
	private UploadUtil uploadUtil;
	
	@Resource(name="configurationUtil")
	private ConfigurationUtil configurationUtil;
	
	@Resource(name="commonUtil")
	private CommonUtil commonUtil;
	
	@Resource(name="stringUtil")
	private StringUtil stringUtil;

	
	/**
	 * Main View
	 * @throws FileNotFoundException 
	 * @throws ConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	@RequestMapping(value="/")
	public ModelAndView Mains() throws FileNotFoundException, IOException{
		List<?> superCategory = configurationUtil.getXmlList("front.navList.superCategory.title");
		List<?> superCategoryUrl = configurationUtil.getXmlList("front.navList.superCategory.url");
		
		List<?> category = configurationUtil.getXmlList("front.navList.superCategory.category.title");
		List<?> categoryUrl = configurationUtil.getXmlList("front.navList.superCategory.category.url");
		
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> hashData = new HashMap<String, Object>();
		hashData.put("pageGbn", "board");
		commonUtil.excelDownloads(hashData);
		
		return new ModelAndView("main");
	}
	
	
	/**
	 * Main GetKeyWordList
	 * @param param
	 */
	@RequestMapping(value="/getMainKeyWordList.ajax")
	public ModelAndView getMainKeyWordList(@RequestParam HashMap<String, Object> param){
		ModelAndView mv = new ModelAndView("jsonView");
		return mv;
	}
	
	@RequestMapping(value="/search")
	public ModelAndView searchView(@RequestParam HashMap<String, Object> param){
		ModelAndView mvc = new ModelAndView("fr/search/searchList");
		mvc.addObject("storeList", stayComidaServiceImpl.getSearchStoreList(param));
		return mvc;
	}
	
	/*
	 * File Uppload Test
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam HashMap<String, Object> param, @RequestParam(value ="files") MultipartFile mFile) throws IllegalStateException, IOException{
		System.out.println(mFile);
		System.out.println(uploadUtil.fileUpload(mFile, ""));
		ModelAndView mvc = new ModelAndView("fr/searchList");
		return mvc;
	}*/
}
