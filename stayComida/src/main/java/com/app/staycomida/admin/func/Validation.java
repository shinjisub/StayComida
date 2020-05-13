package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validation extends AdminCommonCode {
   
   private List<HashMap<String, String>> validations = new ArrayList<HashMap<String, String>>();
   
   public List<HashMap<String, String>> getValidations () {
	   return this.validations;
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

}
