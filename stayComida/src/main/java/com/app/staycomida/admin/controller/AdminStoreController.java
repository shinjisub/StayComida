package com.app.staycomida.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminStoreController {

	@RequestMapping(value="/admin/store/list")
	public ModelAndView StoreList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/store/list");
		return mv;
	}
	
	@RequestMapping(value="/admin/store/write")
	public ModelAndView StoreWrite(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/store/write");
		return mv;
	}
	
}
