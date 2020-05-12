package com.app.staycomida.admin.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validation extends AdminCommonCode {
   
   private List<HashMap<String, String>> validations;
   
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
   
   public List<String> check(HashMap<String, Object> data) {
      List<String> result = new ArrayList<String>();
      for (HashMap<String, String> validation : validations) {
          if (data.get(validation.get("name")) == null || data.get(validation.get("name")).equals("")) {
             result.add(validation.get("message"));
          }
      }
      return result;
   }
   
}
