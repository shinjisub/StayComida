package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SqlParams {
	
	private List<String> select = new ArrayList<String>();
	private List<HashMap<String, String>> join = new ArrayList<HashMap<String, String>>();
	private Boolean iswhere = false;
	private List<HashMap<String, String>> where = new ArrayList<HashMap<String, String>>();
	private List<HashMap<String, String>> like = new ArrayList<HashMap<String, String>>();
	private List<HashMap<String, String>> orderby = new ArrayList<HashMap<String, String>>(); 
	private HashMap<String, Object> limit = new HashMap<String, Object>();
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	private Integer dafaultLimit = 10;
	
	public SqlParams setSelect(String value) {
		this.select.add(value);
		return this;
	}
	
	public SqlParams setJoin(String table, String on, String type) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("table", table);
		param.put("on", on);
		param.put("type", type);
		this.join.add(param);
		return this;
	}
	
	public SqlParams setJoin(String table, String on) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("table", table);
		param.put("on", on);
		param.put("type", "INNER");
		this.join.add(param);
		return this;
	}
	
	public SqlParams setWhere(String key, String value) {
		if (value != null && !value.equals("")) {
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("key", key);
			param.put("value", value);
			this.where.add(param);
			this.iswhere = true;
		}
		return this;
	}
	
	public SqlParams setLike(String key, String value) {
		if (value != null && !value.equals("")) {
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("key", key);
			param.put("value", value);
			this.like.add(param);
			this.iswhere = true;
		}
		return this;
	}
	
	public SqlParams setOrderby(String key, String value) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("key", key);
		param.put("value", value);
		this.orderby.add(param);
		return this;
	}
	
	public SqlParams setOrderby(String value) {
		if (value != null && !value.equals("")) {
			HashMap<String, String> param = new HashMap<String, String>();
			String[] arr = value.split("-");
			System.out.println(arr);
			param.put("key", arr[0]);
			param.put("value", arr[1]);
			this.orderby.add(param);
		}
		return this;
	}
	
	public SqlParams setLimit(Integer page, Integer limit) {
		page = page == null ? 1 : page;
		limit = limit == null ? this.dafaultLimit : limit; 
		this.limit.put("page", page);
		this.limit.put("limit", limit);
		this.limit.put("offset", (page - 1) * limit);
		return this;
	}
	
	public HashMap<String, Object> getLimit() {
		return this.limit;
	}
	
	public SqlParams setData(String key, String value) {
		this.data.put(key, value);
		return this;
	}
	
	public SqlParams setData(HashMap<String, Object> data) {
		this.data = data;
		return this;
	}
	
	public Integer getDefaultLimit() {
		return this.dafaultLimit;
	}
	
	public void clear() {
		this.select.clear();
		this.join.clear();
		this.iswhere = false;
		this.where.clear();
		this.like.clear();
		this.orderby.clear();
		this.limit.clear();
		this.data.clear();
	}
	
	 public HashMap<String, Object> getParams() { 
		 HashMap<String, Object> params = new HashMap<String, Object>(); 
		 params.put("select", this.select); 
		 params.put("join", this.join);
		 params.put("iswhere", this.iswhere); 
		 params.put("where", this.where); 
		 params.put("like", this.like); 
		 params.put("orderby", this.orderby); 
		 params.put("limit", this.limit); 
		 params.put("data", this.data); 
		 return params; 
	 }
	
}
