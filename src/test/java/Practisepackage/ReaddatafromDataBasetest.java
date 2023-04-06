package Practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReaddatafromDataBasetest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			//step 1:create object for driver
			Driver driver=new Driver();
			
			//step 2:register the database
			DriverManager.registerDriver(driver);
			
			//step 3:Get the connection for the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			
			//step 4:create statement
			Statement state = con.createStatement();
			String query = "select * from records;";
			
			//step 5:execute query
			 ResultSet result = state.executeQuery(query);
			 
			 while(result.next()) {
				 System.out.println(result.getString(1)+" "+result.getString(2)+" " +result.getString(3)+result.getString(4)+" "+result.getString(5));
			 }
			
		}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}

	}

}
