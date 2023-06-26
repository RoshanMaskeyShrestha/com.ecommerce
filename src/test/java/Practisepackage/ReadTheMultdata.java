package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.GenericUtilities.ExcelUtility;

public class ReadTheMultdata {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("BillingShipping ");
	int count = sh.getLastRowNum();
	for (int i = 1; i < count; i++) {
		
		String org = sh.getRow(i).getCell(0).getStringCellValue();
		String loc = sh.getRow(i).getCell(1).getStringCellValue();
		System.out.println(org+ " "+loc);
	}
	//just checking my Elib method
	ExcelUtility e=new ExcelUtility();
	System.out.println(e.getlastRow("BillingShipping "));
	String text = e.readmultipleData("BillingShipping ", "shippingaddress ");
	System.out.println(text);
	
	
	
		

	}

}
