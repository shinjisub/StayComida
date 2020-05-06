package com.app.staycomida.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMainController {
	
	@RequestMapping(value= "/admin")
	public ModelAndView Main(){
		ModelAndView mv = new ModelAndView("admin/main");
		return mv;
	}
	
	
}
