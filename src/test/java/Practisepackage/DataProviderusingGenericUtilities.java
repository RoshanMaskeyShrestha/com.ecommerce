package Practisepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class DataProviderusingGenericUtilities {
	@Test(dataProvider = "data")
	public void getdata(String src,String des,String loc) {
		System.out.println(src+des+loc);
	}
@DataProvider
public Object[][] data() throws Throwable {
	ExcelUtility elib = new ExcelUtility();
	Object[][] value = elib.readMultipleSetofData("DP");
	return value;
}
}
