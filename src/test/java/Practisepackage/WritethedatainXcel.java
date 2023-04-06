package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritethedatainXcel {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(4);
		Cell cel = r.getCell(0);
		 cel.setCellValue("DevopSpider");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fos);
		wb.close();

	}
	

}
