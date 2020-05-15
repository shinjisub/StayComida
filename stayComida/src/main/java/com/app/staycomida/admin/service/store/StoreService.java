package com.app.staycomida.admin.service.store;

import java.util.HashMap;
import java.util.List;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Store;

public interface StoreService {
	public HashMap<String, Object> getListCount(SqlParams sqlParams);
	public List<Store> getList(SqlParams sqlParams);
	public Store getInfo(SqlParams sqlParams);
	public int getCount(SqlParams sqlParams);
	public Integer update(SqlParams sqlParams);
}
