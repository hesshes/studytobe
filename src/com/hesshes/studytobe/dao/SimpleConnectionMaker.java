package com.hesshes.studytobe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ¸®½ºÆ® 1-7
public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tobe?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "tobe",
				"tobe");
		return c;
	}
}
