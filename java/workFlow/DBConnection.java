package workFlow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public String connectDB() throws ClassNotFoundException, SQLException {


		String url	= "jdbc:mysql://65.2.162.180:3306/"; 
		String query  = "Select * from giottus.customer where id='617'"; 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection connect = DriverManager.getConnection(url);
		Statement stmnt = connect.createStatement();
		ResultSet rs= stmnt.executeQuery(query); 
		rs.next();
		String otp_mobile = rs.getString("mobile_otp");
    //   System.out.println(otp_mobile); 
		stmnt.close(); 
		connect.close();
		return otp_mobile;
	}
}
