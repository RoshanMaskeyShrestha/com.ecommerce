package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultDataInXcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		for(int i=9;i<19;i++)
		{
			sh.createRow(i).createCell(0).setCellValue("roshan");
			
			
			
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fos);
		wb.close();
		
		
		

	}

}
