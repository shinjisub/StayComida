package com.app.staycomida.admin.service.store;

import java.util.List;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Store;

public interface StoreInterface {
	public List<Store> getList(SqlParams sqlParams);
	public Store getInfo(SqlParams sqlParams);
	public Integer update(SqlParams sqlParams);
}
