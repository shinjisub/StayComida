package com.app.staycomida.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.staycomida.common.ConfigurationUtil;
import com.app.staycomida.common.UploadUtil;
import com.app.staycomidaService.StayComidaServiceImpl;

@Controller
public class MainController {

	@Autowired
	private StayComidaServiceImpl stayComidaServiceImpl;
	
	@Resource(name="uploadUtil")
	private UploadUtil uploadUtil;
	
	@Resource(name="configurationUtil")
	private ConfigurationUtil configurationUtil;
	
	/**
	 * Main View
	 */
	@RequestMapping(value="/")
	public String Mains(){
		return "main";
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
