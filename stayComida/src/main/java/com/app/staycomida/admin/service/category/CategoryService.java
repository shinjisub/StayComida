package com.app.staycomida.admin.service.category;

import java.util.List;

import com.app.staycomida.admin.func.SqlParams;
import com.app.staycomida.admin.object.Category;

public interface CategoryService {
	public List<Category> getList(SqlParams sqlParams);
	public Category getInfo(SqlParams sqlParams);
}
