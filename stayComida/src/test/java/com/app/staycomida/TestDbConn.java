package com.app.staycomida;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestDbConn {

	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://아이피:3306/데이터베이스";
		String DB_USER = "이름";
		String DB_PASSWORD= "암호";

		Connection conn;
		Statement stmt;

		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		 stmt = (Statement) conn.createStatement();
		 conn.close();
		 System.out.println("MySql jdbc test: connect ok!!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}


