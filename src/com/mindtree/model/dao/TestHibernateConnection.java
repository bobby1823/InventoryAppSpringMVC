package com.mindtree.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestHibernateConnection {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/inventorydb?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
