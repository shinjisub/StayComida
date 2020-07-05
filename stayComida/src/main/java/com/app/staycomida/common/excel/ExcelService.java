package com.app.staycomida.common.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Common Excel Service
 * @author User
 *
 */
public interface ExcelService {

	public void ExcelDownLoad(HashMap<String, Object> input) throws FileNotFoundException, IOException;
	public boolean ExcelUpload(HashMap<String, Object> input);
}
