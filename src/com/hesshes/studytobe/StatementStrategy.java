package com.hesshes.studytobe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// list 3-8
public interface StatementStrategy {
	PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
