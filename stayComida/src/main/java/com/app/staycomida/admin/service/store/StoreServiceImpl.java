package com.app.staycomida.admin.service.store;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Store;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private SqlSession sql;
	
	private String prefix = "store";
	
	@Override
	public HashMap<String, Object> getListCount(SqlParams sqlParams) {
		List<Store> list = this.getList(sqlParams);
		int count = this.getCount(sqlParams);
		
		HashMap<String, Object> limit = sqlParams.getLimit();
		if (!limit.isEmpty()) {
			int num = count - ((int) limit.get("limit") * ((int) limit.get("page") - 1));
			for (int i=0; i<list.size(); i++) {
				list.get(i).setNum(num);
				num--;
			}
		}
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("list", list);
		result.put("count", count);
		return result;
	}
	
	@Override
	public List<Store> getList(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectList(prefix + "GetList", params);
	}

	@Override
	public Store getInfo(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectOne(prefix + "GetInfo", params);
	}
	
	@Override
	public int getCount(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectOne(prefix + "GetCount", params);
	}

	@Override
	public Integer update(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.insert(prefix + "Update", params);
	}

	@Override
	public Integer delete(SqlParams sqlParams) {
		if (sqlParams.getWhere().size() == 0 && sqlParams.getLike().size() == 0) {
			return 0;
		}
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.delete(prefix + "Delete", params);
	}

}
