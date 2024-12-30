package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

//	public static void main(String[] args) throws IOException {
//		
//		ReadXLSdata red = new ReadXLSdata();
//		red.getdata("login");
//		
//
//	}
	
	
	@DataProvider(name = "exceldata")
	public String[][] getdata(Method m) throws IOException {
		String excelSheetName = m.getName();
		File path = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fs = new FileInputStream(path);
		
	//	XSSFWorkbook wb = new XSSFWorkbook(fs);
	//	XSSFSheet sh = wb.getSheetAt(0);
		
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		// get last rowNum & colNum
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		// formate the file to get string int or number to read
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		for(int i=1; i<=totalRows;i++) {
			for(int j=0; j<totalCols;j++) {
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;
		
		
	}

}
