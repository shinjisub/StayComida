package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.List;

public class AdminLimitSelect {
	
	private String openTag = 	"<label>" + 
			"						<select name=\"limit\" aria-controls=\"basic-datatables\" class=\"form-control form-control-sm admin-limit-select\">";
	
	private String optionTag = 			"<option value=\"[[limit]]\" [[selected]]>[[limit]]개씩 보기</option>";
	
	private String closeTag = 		"</select>" + 
								"</label>";
	
	private List<Integer> limitList = new ArrayList<Integer>();
	
	public AdminLimitSelect (int num1, int num2) {
		this.limitList.add(num1);
		this.limitList.add(num2);
	}
	
	public AdminLimitSelect (int num1, int num2, int num3) {
		this.limitList.add(num1);
		this.limitList.add(num2);
		this.limitList.add(num3);
	}
	
	public AdminLimitSelect (int num1, int num2, int num3, int num4) {
		this.limitList.add(num1);
		this.limitList.add(num2);
		this.limitList.add(num3);
		this.limitList.add(num4);
	}
	
	public AdminLimitSelect (int num1, int num2, int num3, int num4, int num5) {
		this.limitList.add(num1);
		this.limitList.add(num2);
		this.limitList.add(num3);
		this.limitList.add(num4);
		this.limitList.add(num5);
	}

	public AdminLimitSelect optionAdd(int num) {
		this.limitList.add(num);
		return this;
	}
	
	public String getSelect(Integer limit) {
		String select = "";
		if (this.limitList.size() > 0) {
			select += openTag;
			for (int i = 0; i < this.limitList.size(); i++) {
				Integer limitNum = this.limitList.get(i);
				String option = optionTag.replace("[[limit]]", Integer.toString(limitNum));
				if (limit != null && limit.equals(limitNum)) {
					option = option.replace("[[selected]]", "selected");
				} else {
					option = option.replace("[[selected]]", "");
				}
				select += option;
			}
			select += closeTag;
		}
		return select;
	}
	

}
