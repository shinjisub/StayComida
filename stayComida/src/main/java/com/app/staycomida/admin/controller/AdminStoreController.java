package com.app.staycomida.admin.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.staycomida.admin.func.AdminLimitSelect;
import com.app.staycomida.admin.func.AdminPagination;
import com.app.staycomida.admin.func.AjaxResult;
import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.func.Validation;
import com.app.staycomida.admin.service.category.CategoryServiceImpl;
import com.app.staycomida.admin.service.store.StoreServiceImpl;

@Controller
public class AdminStoreController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private StoreServiceImpl storeServiceImpl;
	
	@RequestMapping(value="/admin/store/list")
	public ModelAndView StoreList(
			HttpServletRequest request, 
			@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer limit, 
			@RequestParam(required = false) String searchword, 
			@RequestParam(required = false) String orderby
		) throws IOException {
		ModelAndView mv = new ModelAndView("admin/store/list");
		try {
			
			SqlParams sqlParams = new SqlParams();
			sqlParams.setSelect("A.*");
			sqlParams.setSelect("B.category_name");
			sqlParams.setSelect("LEFT(A.store_created, 10) as store_created");
			sqlParams.setJoin("stay_category B", "A.scgid = B.scgid");
			sqlParams.setLike("store_name", searchword);
			sqlParams.setOrderby(orderby);
			sqlParams.setLimit(page, limit);
			
			HashMap<String, Object> storeList = storeServiceImpl.getListCount(sqlParams);
			mv.addObject("storeList", storeList);
		
			AdminPagination adminPagination = new AdminPagination(request, page, storeList.get("count"), limit);
			mv.addObject("paging", adminPagination.getPaging());
			
			AdminLimitSelect adminLimitSelect = new AdminLimitSelect(10, 20, 30, 50, 100);
			mv.addObject("limitSelect", adminLimitSelect.getSelect(limit));
			
			mv.addObject("page", adminPagination.getCurPage());
			mv.addObject("searchword", (searchword == null ? "" : searchword));
			mv.addObject("orderby", (orderby == null ? null : orderby.split("-")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/store/write")
	public ModelAndView StoreWrite() throws IOException {
		ModelAndView mv = new ModelAndView("admin/store/write");
		try {
			mv.addObject("categoryList", categoryServiceImpl.getList(new SqlParams()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/store/write/submit", method = RequestMethod.POST)
	public HashMap<String, Object> StoreWriteSubmit(@RequestParam HashMap<String, Object> postData) throws IOException {
		Validation validation = new Validation();
		validation.setRules("scgid", "매장 카테고리", "select");
		validation.setRules("store_name", "매장명", "input");
		validation.setRules("store_zipcode", "주소", "input");
		validation.setRules("store_address1", "주소", "input");
		
		AjaxResult ajaxResult = new AjaxResult(validation);
		HashMap<String, Object> valiResult = ajaxResult.validation(postData);
		if (valiResult.get("resultCode").equals(ajaxResult.validationFailCode)) {
			return valiResult;
		}
		
		SqlParams sqlParams = new SqlParams();
		sqlParams.setData(postData);
		if (storeServiceImpl.update(sqlParams) > 0) {
			return ajaxResult.success();
		} else {
			return ajaxResult.fail();
		}
	}
}
