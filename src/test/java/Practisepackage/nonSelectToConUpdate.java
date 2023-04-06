package Practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class nonSelectToConUpdate {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int result=0;
		try {
		Driver driver=new Driver();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement state = con.createStatement();
		String query = "insert into emp values(102,73376692,'roshan','maskey');";
		result=state.executeUpdate(query);
		
		}
		catch (Exception e) {
			
		}
		finally {
			if(result==1)
			{
				System.out.println("done");
			}
			else {
				System.out.println("not updated");
			}
			con.close();
		}
		

	}

}
