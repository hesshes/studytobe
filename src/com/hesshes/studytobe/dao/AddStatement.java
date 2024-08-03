package com.hesshes.studytobe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hesshes.studytobe.StatementStrategy;
import com.hesshes.studytobe.domain.User;

// list 3-13, 3-14
public class AddStatement implements StatementStrategy {
    User user;

    public AddStatement(User user) {
        this.user = user;
    }

    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into user(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        return ps;
    }
}
