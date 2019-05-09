package ExelHandeling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExelData {

	
	public void readExcel(String path,String fileName,String sheetName) throws IOException {
		
		File file = new File(path+"\\"+fileName);
		
		//Create object of FileInputStream to read data
		FileInputStream inputStream = new FileInputStream(file);
		
		  Workbook ExelWorkbook = null;
		  
		//Check extension of file
		String fileExtension = fileName.substring(fileName.indexOf("."));
		
		//If file extension is .xls then create object of HSSFWorkbook class
		if(fileExtension.equals("xls")) {
			ExelWorkbook = new HSSFWorkbook(inputStream);
		}
		
		//If file extension is .xlsx then create object of XSSFWorkbook class
		else if (fileExtension.equals(".xlsx")) {
			
			ExelWorkbook = new XSSFWorkbook(inputStream);
		}
		
		//Read sheet
		Sheet ExelSheet = ExelWorkbook.getSheet(sheetName);
		
		//No of rows 
		int rowCount = ExelSheet.getLastRowNum()-ExelSheet.getFirstRowNum();
		
		 System.out.printf("%-10s %-10s ", "Name", "Address");
		 System.out.println();
		  System.out.println("-----------------------------------------------------------------------------");
		for(int i=1;i<=rowCount;i++) {
			
			//get row 
			Row row = ExelSheet.getRow(i);
			
			 for(int j=0;j<=row.getLastCellNum()-1;j++) {
				 
				 //Print data
				// System.out.println("Cell data :"+row.getCell(j).getStringCellValue() +" || ");
				
				  
				 System.out.format("%-10s",row.getCell(j).getStringCellValue());
				 
			 }
			 System.out.println();
			 System.out.println("-----------------------------------------------------------------------------"); 
		}
	}
}


