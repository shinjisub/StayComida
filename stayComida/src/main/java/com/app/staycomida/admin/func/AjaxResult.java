package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AjaxResult extends AdminCommonCode {
	
	Validation validations = new Validation();
	
	public AjaxResult () { }
	
	public AjaxResult (Validation validations) {
		this.validations = validations;
	}
	
	public void setValidations (Validation validations) {
		this.validations = validations;
	}
	
	public HashMap<String, Object> validation (HashMap<String, Object> data) {
		
		List<HashMap<String, String>> valiResult = new ArrayList<HashMap<String, String>>();
		
		for (HashMap<String, String> vali : this.validations.getValidations()) {
			if (data.get(vali.get("name")) == null || data.get(vali.get("name")).equals("")) {
				HashMap<String, String> valiFail = new HashMap<String, String>();
				valiFail.put("name", vali.get("name"));
				valiFail.put("message", vali.get("message"));
				valiResult.add(valiFail);
			}
		}
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		if (valiResult.size() > 0) {
			result.put("resultCode", this.validationFailCode);
			result.put("validationFailList", valiResult);
		} else {
			result.put("resultCode", this.validationSuccessCode);
		}
		
		return result;
	}
	
	
	public HashMap<String, Object> success() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.successCode);
		return result;
	}
	
	public HashMap<String, Object> success(HashMap<String, Object> data) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.successCode);
		result.put("resultData", data);
		return result;
	}
	
	public HashMap<String, Object> fail() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.failCode);
		return result;
	}
	
	public HashMap<String, Object> fail(HashMap<String, Object> data) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.failCode);
		result.put("resultData", data);
		return result;
	}
	
	public HashMap<String, Object> necessaryNull() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.necessaryNullCode);
		return result;
	}
	
	public HashMap<String, Object> necessaryNull(HashMap<String, Object> data) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", this.necessaryNullCode);
		result.put("resultData", data);
		return result;
	}

}
