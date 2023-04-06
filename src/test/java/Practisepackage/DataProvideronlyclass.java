package Practisepackage;

import org.testng.annotations.Test;

public class DataProvideronlyclass {
	@Test(dataProviderClass = DataProviderwithExcel.class,dataProvider = "data")
	public void getdata(String src,String des,String loc) {
		System.out.println(src+des+loc);
	}

}
