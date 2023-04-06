package Practisepackage;

import org.testng.annotations.DataProvider;

public class Dataproviderhandlingclass {
	@DataProvider
	public Object[][]data(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="java";
		obj[0][1]="sql";
		obj[0][2]="manual";
		
		obj[1][0]="shuruti mam";
		obj[1][1]="Riza sir";
		obj[1][2]="ramiya mam";
		return obj;
		
		
	}

}
