package com.birundha.config;

import java.sql.*;
public class jdbcconnection {

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{


		String url="jdbc:h2:tcp://localhost/~/test";
		String username="sa";
		String password="";

		Class.forName("org.h2.Driver");
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
		}
		}	

