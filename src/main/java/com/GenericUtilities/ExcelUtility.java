package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import java.lang.Object;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author mmask
 *
 */

public class ExcelUtility {
public String readingdatafromExcel(String Sheetname,int rownum,int cellnum) throws Throwable {
	FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	 String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
	 return value;
}

public Object[][] readMultipleSetofData(String Sheetname) throws Throwable{
	FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(Sheetname);
	 int lastrow = sh.getLastRowNum()+1;
	 int lastcell = sh.getRow(0).getLastCellNum();
	 
	Object[][] value = new Object[lastrow][lastcell];
	
	for(int i=0; i<lastrow; i++)
	{
		for(int j=0; j<lastcell; j++)
		{
			value[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return value;
}
/**
 * 
 * @param Sheetname
 * @return
 * @throws Throwable
 * @throws IOException
 */
public int getlastRow(String Sheetname) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	int count=sh.getLastRowNum();
	return count;
	
	
	
}
/**
 * 
 * @param Sheetname
 * @param rownum
 * @param cellnum
 * @param data
 * @throws Throwable
 * @throws IOException
 */
public void writedataintoExcel(String Sheetname,int rownum,int cellnum,String data) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	sh.getRow(rownum).getCell(cellnum).setCellValue(data);
	FileOutputStream fos = new FileOutputStream(Ipathconstants.Excelpath);
	wb.write(fos);
	
}
/**
 * 
 * @param Sheetname
 * @return
 * @throws Throwable
 */
public HashMap<String,String>readmultipleData(String Sheetname) throws Throwable{
	FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	int count=sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for (int i =0;i<=count;i++) {
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		
	}
	return map;
	
	
}


	 
	 

}
















