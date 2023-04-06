package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadthedatafromXcel {

	public static void main(String[] args) throws Throwable {
     FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet1");
    Row r = sh.getRow(1);
    Cell cel = r.getCell(1);
   String value = cel.getStringCellValue();
   System.out.println(value);
    
	}

}
