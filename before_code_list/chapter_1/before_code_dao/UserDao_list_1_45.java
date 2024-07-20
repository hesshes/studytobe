package com.hesshes.studytobe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hesshes.studytobe.domain.User;

//list 1-45
public class UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private ConnectionMaker connectionMaker;
	// 아래 로컬 변수들은 싱글톤으로 동작하는 스프링에서는 심각한 문제를 일으키는 예제코드
	private Connection c;
	private User user;

	public UserDao() {
	}

	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws SQLException {

		this.c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("insert into user (id, name, password) values(?,?,?)");

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws SQLException {

		this.c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from user where id = ?");

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return this.user;
	}

}
