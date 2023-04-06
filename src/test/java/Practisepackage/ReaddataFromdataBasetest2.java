package Practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class ReaddataFromdataBasetest2 {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement state = con.createStatement();
		 String query = "insert into records values('roshi',984714078,152,'ktm',985107895);";
		  int result = state.executeUpdate(query);
		  con.close();
		 
		 
		

	}

}
