package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SqlParams {
	
	private List<String> select = new ArrayList<String>();
	private Boolean iswhere = false;
	private List<HashMap<String, Object>> where = new ArrayList<HashMap<String, Object>>();
	private List<HashMap<String, Object>> like = new ArrayList<HashMap<String, Object>>();
	private List<HashMap<String, Object>> orderby = new ArrayList<HashMap<String, Object>>(); 
	private HashMap<String, Object> limit = new HashMap<String, Object>();
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	public void setSelect(String value) {
		this.select.add(value);
	}
	
	public void setWhere(String key, Object value) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		param.put("value", value);
		this.where.add(param);
		this.iswhere = true;
	}
	
	public void setLike(String key, Object value) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		param.put("value", value);
		this.like.add(param);
		this.iswhere = true;
	}
	
	public void setOrderby(String key, Object value) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		param.put("value", value);
		this.orderby.add(param);
	}
	
	public void setLimit(int page, int limit) {
		this.limit.put("page", page);
		this.limit.put("limit", limit);
		this.limit.put("offset", (page - 1) * limit);
	}
	
	public void setData(String key, Object value) {
		this.data.put(key, value);
	}
	
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	 public HashMap<String, Object> getParams() { 
		 HashMap<String, Object> params = new HashMap<String, Object>(); 
		 params.put("select", this.select); 
		 params.put("iswhere", this.iswhere); 
		 params.put("where", this.where); 
		 params.put("like", this.like); 
		 params.put("orderby", this.orderby); 
		 params.put("limit", this.limit); 
		 params.put("data", this.data); 
		 return params; 
	 }
	
}
