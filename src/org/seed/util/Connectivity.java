package org.seed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String DB_USER="system";
	public static final String DB_PASS="jayendra";
	private static Connection con;
	
	
	public static Connection connect(){
		try {
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
