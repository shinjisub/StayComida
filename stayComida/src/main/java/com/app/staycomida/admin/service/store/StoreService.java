package com.app.staycomida.admin.service.store;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Store;

@Service
public class StoreService implements StoreInterface {
	
	@Autowired
	private SqlSession sql;
	
	@Override
	public List<Store> getList(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectList("storeGetList", params);
	}

	@Override
	public Store getInfo(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectOne("storeGetInfo", params);
	}

	@Override
	public Integer update(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.insert("storeUpdate", params);
	}

}
