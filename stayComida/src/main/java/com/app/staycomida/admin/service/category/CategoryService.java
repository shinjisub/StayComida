package com.app.staycomida.admin.service.category;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Category;

@Service
public class CategoryService implements CategoryInterface {
	
	@Autowired
	private SqlSession sql;
	
	@Override
	public List<Category> getList(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectList("categoryGetList", params);
	}
	
	@Override
	public Category getInfo(SqlParams sqlParams) {
		HashMap<String, Object> params = sqlParams.getParams();
		return sql.selectOne("categoryGetInfo", params);
	}
	
}
