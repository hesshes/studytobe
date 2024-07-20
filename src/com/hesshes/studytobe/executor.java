package com.hesshes.studytobe;

import java.sql.SQLException;

import org.junit.runner.JUnitCore;

//list_2-6
public class executor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JUnitCore.main("com.hesshes.studytobe.UserDaoTestJunit");
	}
}
