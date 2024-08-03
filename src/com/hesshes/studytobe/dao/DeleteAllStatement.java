package com.hesshes.studytobe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hesshes.studytobe.StatementStrategy;

// list 3-9
public class DeleteAllStatement implements StatementStrategy { 
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from user");
		return ps;
	}
}
