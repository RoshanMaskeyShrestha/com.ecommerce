package com.GenericUtilities;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author mmask
 *
 */

public class DatabaseUtility {
	Connection con=null;
	public void connecttoDb() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Ipathconstants.DBURL, Ipathconstants.DBUSERNAME, Ipathconstants.DBPASSWORD);
		
	}
	/**
	 * author roshan
	 * @param query
	 * @param edata
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public  String executeQueryAndGetData(String query,String edata,int cell) throws Throwable {
		  ResultSet result = con.createStatement().executeQuery(query);
		  boolean flag=false;
		  while(result.next()) {
			  String adata=result.getString(cell);
			  if(adata.equalsIgnoreCase(edata)) {
				  flag=true;
				  break;
			  }
		  }
		  if(flag) {
			  System.out.println("data is verified");
			  return edata;
		  }
		  else {
			  System.out.println("data is not verified");
			  return null;
			  
		  }
	}
	/**
	 * author roshan
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable {
		con.close();
		  
		System.out.println("database connection closed");
		
	}
			

}
