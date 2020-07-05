package com.app.staycomida.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.staycomida.common.excel.ExcelService;

@RequestMapping( value="/common" )
public class CommonUtil extends CommonCode {
	
	@Resource( name="excelService" )
	private ExcelService excelService;
	
	@RequestMapping( value="/excelDownload" )
	public String excelDownloads(@RequestParam HashMap<String, Object> input) throws FileNotFoundException, IOException {
		
		if(input != null && !"".equals(input)){
			input.put("keyWord", "홍대개미");
			excelService.ExcelDownLoad(input);
		}else {
			System.out.println("Error");
		}
		
		return "";
	}

	@RequestMapping( value="/excelUpload" )
	public String excelUploads(@RequestParam HashMap<String, Object> input){
		
		
		return "";
	}
}
