package com.app.staycomidacommon;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Common Service Class
 * @author User
 *
 */
@Controller
public class Common {
	
	@Autowired
	private SqlSession sql;

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
			mv.addObject("data", e.getMessage());
			mv.addObject("resultCode", 100);
		}

		return mv;
	}
}
