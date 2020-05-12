package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validation extends AdminCommonCode {
   
   private List<HashMap<String, String>> validations;
   
   private AdminCommonCode commonCode = new AdminCommonCode();
   
   public Validation() {
      this.validations = new ArrayList<HashMap<String, String>>();
   }
   
   public void setRules(String inputName, String name, String inputType) {
      String message = "";
      switch (inputType) {
         case "input":
            message = name+"은(는) 필수 입력사항입니다.";
            break;
         case "select":
         case "radio":
         case "checkbox":
            message = name+"은(는) 필수 선택사항입니다.";
            break;
         default:
            message = inputType;
            break;
      }
      HashMap<String, String> validation = new HashMap<String, String>();
      validation.put("name", inputName);
      validation.put("message", message);
      validations.add(validation);
   }
   
   public HashMap<String, Object> check(HashMap<String, Object> data) {
	  List<HashMap<String, String>> valiResult = new ArrayList<HashMap<String, String>>();
      HashMap<String, String> valiFail = new HashMap<String, String>();
      for (HashMap<String, String> validation : validations) {
          if (data.get(validation.get("name")) == null || data.get(validation.get("name")).equals("")) {
        	  valiFail.clear();
        	  valiFail.put("name", validation.get("name"));
        	  valiFail.put("message", validation.get("message"));
        	  valiResult.add(valiFail);
          }
      }
      
      HashMap<String, Object> result = new HashMap<String, Object>();
      result.put("valiResult", valiResult);
      if (valiResult.size() > 0) {
    	  result.put("resultCode", this.commonCode.getValidationCode());
      }
      return result;
   }
   
}
