package com.app.staycomidacommon;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Common Service Class
 * @author User
 *
 */
public class Common {
	
	@Autowired
	private SqlSession sql;

	private ModelAndView mv;

	/**
	 * Common retrieve Service
	 * @param param
	 * @return
	 */
	public ModelAndView getRetrieve(@RequestParam HashMap<String, Object> param){
		mv.addObject("test", 111);
		sql.selectList("", "");
		return mv;
	}
}
