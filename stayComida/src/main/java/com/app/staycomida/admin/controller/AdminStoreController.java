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

import com.app.staycomida.admin.func.AdminCommon;
import com.app.staycomida.admin.func.AdminLimitSelect;
import com.app.staycomida.admin.func.AdminPagination;
import com.app.staycomida.admin.func.AjaxResult;
import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.func.Validation;
import com.app.staycomida.admin.object.Store;
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
			@RequestParam(required = false) String searchword
		) throws IOException {
		ModelAndView mv = new ModelAndView("admin/store/list");
		try {
			SqlParams sqlParams = new SqlParams();
			sqlParams.setSelect("A.*");
			sqlParams.setSelect("B.category_name");
			sqlParams.setSelect("LEFT(A.store_created, 10) as store_created");
			sqlParams.setJoin("stay_category B", "A.scgid = B.scgid");
			sqlParams.setLike("store_name", searchword);
			sqlParams.setOrderby("ssid", "DESC");
			sqlParams.setLimit(page, limit);
			
			//매장 목록
			HashMap<String, Object> storeList = storeServiceImpl.getListCount(sqlParams);
			mv.addObject("storeList", storeList);
			
			//페이지 네이션
			AdminPagination adminPagination = new AdminPagination(request, page, storeList.get("count"), limit);
			mv.addObject("paging", adminPagination.getPaging());
			
			AdminLimitSelect adminLimitSelect = new AdminLimitSelect(10, 20, 30, 50, 100);
			mv.addObject("limitSelect", adminLimitSelect.getSelect(limit));
			
			AdminCommon adminCommon = new AdminCommon(request);
			mv.addObject("redirect", adminCommon.getRedirectUrl());
			
			mv.addObject("page", adminPagination.getCurPage());
			mv.addObject("searchword", (searchword == null ? "" : searchword));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/store/write")
	public ModelAndView StoreWrite(@RequestParam(required = false) Integer ssid, @RequestParam(required = false) String redirect) throws IOException {
		ModelAndView mv = new ModelAndView("admin/store/write");
		try {
			if (ssid != null) {
				SqlParams sqlParams = new SqlParams();
				sqlParams.setWhere("ssid", Integer.toString(ssid));
				Store storeInfo = storeServiceImpl.getInfo(sqlParams);
				mv.addObject("storeInfo", storeInfo);
			}
			mv.addObject("categoryList", categoryServiceImpl.getList(new SqlParams()));
			mv.addObject("redirect", (redirect == null ? "/admin/store/list" : redirect));
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
		
		String ssid = (String)postData.get("ssid");
		String updateType = ssid == null ? "등록" : "수정";
		
		SqlParams sqlParams = new SqlParams();
		if (ssid != null) {
			sqlParams.setWhere("ssid", ssid);
		}
		sqlParams.setData(postData);
		
		HashMap<String, Object> resultData = new HashMap<String, Object>();
		if (storeServiceImpl.update(sqlParams) > 0) {
			resultData.put("alert", "매장이 정상적으로 "+updateType+"되었습니다.");
			return ajaxResult.success(resultData);
		} else {
			resultData.put("alert", "매장  "+updateType+"에 실패하였습니다.");
			return ajaxResult.fail(resultData);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/store/delete", method = RequestMethod.POST)
	public HashMap<String, Object> StoreDelete(@RequestParam HashMap<String, Object> postData) throws IOException {
		
		AjaxResult ajaxResult = new AjaxResult();
		
		String ssid = (String)postData.get("ssid");
		if (ssid == null) {
			return ajaxResult.necessaryNull();
		}
		
		SqlParams sqlParams = new SqlParams();
		sqlParams.setWhere("ssid", ssid);
		
		HashMap<String, Object> resultData = new HashMap<String, Object>();
		if (storeServiceImpl.delete(sqlParams) > 0) {
			resultData.put("alert", "매장이 정상적으로 삭제되었습니다.");
			return ajaxResult.success(resultData);
		} else {
			resultData.put("alert", "매장이 삭제에 실패하였습니다.");
			return ajaxResult.fail(resultData);
		}
	}
}
