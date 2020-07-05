package com.app.staycomida.common;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.staycomida.configurations.ConfigurationUtil;

/**
 * Common Service Class
 * @author User
 *
 */
@Controller
public class Common {
	
	@Autowired
	private SqlSession sql;

	@Resource(name="configurationUtil")
	private ConfigurationUtil configurationUtil;

	private ModelAndView mv = null;
	private List<HashMap<String, Object>> result = null;

	/**
	 * Common retrieve Service
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/getRetrieveList.ajax")
	public ModelAndView getRetrieveList(@RequestParam HashMap<String, Object> param){
		String sqlId = String.valueOf(param.get("sqlId"));
		mv = new ModelAndView("jsonView");
		try {
			result = sql.selectList(sqlId, param);
			mv.addObject("data", result);
			mv.addObject("resultCode", 200);
		} catch (Exception e) {
			mv.addObject("errorMsg", e.getMessage());
			mv.addObject("resultCode", 100);
		}

		return mv;
	}
	
	
	/**
	 * Front Common Navigations 
	 * @return
	 */
	@RequestMapping(value="/getNavigationList.ajax")
	public ModelAndView getNavigationList(){
		mv = new ModelAndView("jsonView");

		return mv;
	}
}
