package com.app.staycomida.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.func.Validation;
import com.app.staycomida.admin.service.category.CategoryService;
import com.app.staycomida.admin.service.store.StoreService;

@Controller
public class AdminStoreController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value="/admin/store/list")
	public ModelAndView StoreList() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/store/list");
		return mv;
	}
	
	@RequestMapping(value="/admin/store/write")
	public ModelAndView StoreWrite() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/store/write");
		try {
			mv.addObject("categoryList", categoryService.getList(new SqlParams()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/store/write/submit", method = RequestMethod.POST)
	public void StoreWriteSubmit(@RequestParam HashMap<String, Object> postData) throws IOException {
		Validation validation = new Validation();
		validation.setRules("scgid", "매장 카테고리", "select");
		validation.setRules("store_name", "매장명", "input");
		validation.setRules("store_zipcode", "주소", "input");
		validation.setRules("store_address1", "주소", "input");
		validation.setRules("store_address2", "주소", "input");
		List<HashMap<String, String>> valiResult = validation.check(postData);
		if (valiResult.size() > 0) {
			
		}
		
		SqlParams sqlParams = new SqlParams();
		sqlParams.setData(postData);
		Integer result = storeService.update(sqlParams);
		System.out.println(result);
	}
	
	
	
	
}
