package config;
import java.sql.*;
/*
public class Jdbcconnection {

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{


		String url="jdbc:h2:tcp://localhost/~/test";
		String username="sa";
		String password="";

		Class.forName("org.h2.Driver");
		Class.forName(password)	;
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
		}
		}	
		*/
public class Jdbcconnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException
	
	
	{

		Class.forName("org.h2.Driver");
		Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		return conn;
	}

}

