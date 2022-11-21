package qa.HDFCBank.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelData {
	
	public static Object[][] readExcel() throws IOException {
	
		File file = new File("C:\\Users\\PRAKASH\\eclipse-workspace\\NewProject01\\HDFCBank\\src\\test\\java\\qa\\HDFCBank\\TestData\\loginData.xlsx");
	
		System.out.println("File Exist: "+file.exists());
	
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Guru Bank Login Data");
		
		int numRows = sheet.getPhysicalNumberOfRows();
		
		int numCols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[numRows-1][numCols];
		
		for(int i = 0;i<numRows-1;i++) {
			
			for(int j = 0;j<numCols;j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return data;
		
	}
}
