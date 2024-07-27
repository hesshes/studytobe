package com.hesshes.studytobe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// list 3-9
public class DeleteAllStatement implements StatementStrategy {
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from users");
		return ps;
	}
}
