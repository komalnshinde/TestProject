package ExelHandeling;

import java.io.IOException;

public class ReadExcel {

	public static void main(String []args) throws IOException {
		
		//create object of readExcel 
		ReadExelData readExcel = new ReadExelData();
		
		//Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\resources";

	    //Call readExcel method
		readExcel.readExcel(filePath, "ExportExcel.xlsx","ReadData");
	}
}
