package com.app.staycomidaService;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayComidaServiceImpl implements StayComidaService{
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<HashMap<String, Object>> getSearchStoreList(HashMap<String, Object> param){
		return sql.selectList("getSearchStoreList", param);
	}
}
