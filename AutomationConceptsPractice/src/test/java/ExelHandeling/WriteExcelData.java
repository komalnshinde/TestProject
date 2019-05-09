package ExelHandeling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	
	public static void main(String []args) throws IOException {
		
		 String[] valueToWrite = {"Mr. F","Noida"};
		 
		 String filePath = System.getProperty("user.dir")+"\\resources";
		 
		 WriteExcelData writeExcelData = new WriteExcelData();
		 
		 writeExcelData.writeExcel(filePath, "ExportExcel.xlsx","ReadData",valueToWrite);
	}
	
	
	public void writeExcel(String filePath,String fileName,String sheetName,String [] dataToWrite) throws IOException {
		
		File file = new File(filePath+"\\"+fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook ExelWorkbook = null;
		String fileNameExtension = fileName.substring(fileName.indexOf("."));
		
		
		if(fileNameExtension.equals(".xlsx")) {
			
			ExelWorkbook = new XSSFWorkbook(inputStream);
			
		}else if (fileNameExtension.equals(".xls")) {
			
			ExelWorkbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = ExelWorkbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		//Get row
		Row row = sheet.getRow(0);
		
		//Create a new row and append it at last of sheet
		Row newRow =sheet.createRow(rowCount+1);
		
		 //Create a loop over the cell of newly created Row
		for(int j=0;j<row.getLastCellNum();j++) {
			
			//Fill data in row
			
			Cell cell = newRow.createCell(j);
			
			cell.setCellValue(dataToWrite[j]);
		}
		
		 inputStream.close();
		//Create an object of FileOutputStream class to create write data in excel file

		    FileOutputStream outputStream = new FileOutputStream(file);

		    //write data in the excel file

		    ExelWorkbook.write(outputStream);

		    //close output stream

		    outputStream.close();
			
	}
}
