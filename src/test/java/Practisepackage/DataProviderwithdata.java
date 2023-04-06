package Practisepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





public class DataProviderwithdata {
	@Test(dataProvider = "data")
	public void getdata(String un,String pwd) {
		System.out.println(un+pwd);
	}
		
	
	@DataProvider
	public Object[][] data(){
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin1";
		obj[0][1]="manager1";
		
		obj[1][0]="admin2";
		obj[1][1]="manager2";
		return obj;
		
		
		
		
	}

}
