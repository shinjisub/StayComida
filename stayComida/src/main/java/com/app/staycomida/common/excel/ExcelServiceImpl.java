package com.app.staycomida.common.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.staycomidaService.StayComidaServiceImpl;

/**
 * Common ExcelServiceImpl
 * @author User
 *
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
	
	@Autowired
	private StayComidaServiceImpl stayComidaServiceImpl;
	
	/**
	 * ExcelDownLoads
	 * @throws IOException 
	 */
	@Override
	public void ExcelDownLoad(HashMap<String, Object> input) throws IOException {
		Row row   = null;
		Cell cell = null;
		List<String> sHead = null;
		List<HashMap<String, Object>> sBody = null;
		FileOutputStream fileOutPut = null;
		
		XSSFWorkbook workBook = new XSSFWorkbook(); 
		Sheet sheet = workBook.createSheet();
		String pageGbn = String.valueOf(input.get("pageGbn"));
		String excelExtention = input.containsKey("extention")? input.get("extention").toString() : ".xlsx";
		String fileName = pageGbn.concat(excelExtention);

		//-- Excel Basic Setting
		if("board".equals(pageGbn)){
			String [] head = { "번호", "이름", "제목", "내용", "날짜" }; 
			sHead = Arrays.asList(head);
			sBody = stayComidaServiceImpl.getSearchStoreList(input);
		} else if("다른 페이지의 구분".equals(pageGbn)){
			String [] head = { "번호", "이름", "제목", "내용", "날짜" }; 
			sHead = Arrays.asList(head);
			sBody = stayComidaServiceImpl.getSearchStoreList(input);
		}
		
		System.out.println("-------------------------------");
		System.out.println("input : "+input);
		System.out.println("sHead : "+sHead);
		System.out.println("sHead : "+sBody);
		System.out.println("-------------------------------");

		//-- Excel Create
		int rowCnt = 0;
		if(sBody.isEmpty() == false && sBody.size() > 0){
			for (int i = 0; i < sBody.size(); i++) {
				
				//-- Head Setting
				if(i == 0 && sHead.size() > 0){
					row = sheet.createRow(i);
					for (int j = 0; j < sHead.size(); j++) {
						cell = row.createCell(j);
						cell.setCellValue(sHead.get(j));
					}
				}

				//-- Body
				row = sheet.createRow(i+1);
				for(String str : sBody.get(i).keySet()){
					cell = row.createCell(rowCnt);
					cell.setCellValue(String.valueOf(sBody.get(i).get(str)));
					rowCnt++;
				}
			}
		}


		fileOutPut = new FileOutputStream("C:\\Users\\User\\Desktop\\"+fileName);
		workBook.write(fileOutPut);
		fileOutPut.close();
	}

	/**
	 * Excel Upload
	 */
	@Override
	public boolean ExcelUpload(HashMap<String, Object> input) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Excel Style Setting
	 * @param pWorkBook
	 * @return
	 */
	public XSSFWorkbook setExcelStyle(XSSFWorkbook pWorkBook){
		return pWorkBook;
	}
}
