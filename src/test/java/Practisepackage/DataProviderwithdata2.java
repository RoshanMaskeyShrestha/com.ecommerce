package Practisepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderwithdata2 {
	@Test(dataProvider = "data")
	public void getdata(String src ,String des, String loc  ) {
		System.out.println(src+des+loc );
		
	}
	@DataProvider
	public Object[][] data(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="Qspider";
		obj[0][1]="Testyantra";
		obj[0][2]="Bangalore";
		
		obj[1][0]="Testyantra";
		obj[1][1]="US";
		obj[1][2]="MNC";
	    return obj;
		
		
		
		
		
	}

}
