package com.app.staycomidaController;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.staycomidaService.StayComidaServiceImpl;

@Controller
public class MainController {

	@Autowired
	private StayComidaServiceImpl stayComidaServiceImpl;
	
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
		try {
			mv.addObject("keyWordList", stayComidaServiceImpl.getMainKeyWordList(param));
			mv.addObject("resultCode", 100);
		} catch (Exception e) {
			mv.addObject("resultCode", 200);
			e.printStackTrace();
		}

		return mv;
	}
}
