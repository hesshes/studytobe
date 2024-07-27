package com.hesshes.studytobe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hesshes.studytobe.dao.UserDao;

public class UserDeleteAll extends UserDao {

	protected PreparedStatement makeStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from users");

		return ps;
	}

}
