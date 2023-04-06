package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.Ipathconstants;

public class DataProviderwithExcel {
	@DataProvider
	public Object[][] data() throws Throwable {
		FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][]obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
	}

}
