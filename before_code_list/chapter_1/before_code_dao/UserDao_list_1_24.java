package com.hesshes.studytobe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hesshes.studytobe.domain.User;

//list 1-24 
public class UserDao {

	private ConnectionMaker connectionMaker;
	// �Ʒ� ���� �������� �̱������� �����ϴ� ������������ �ɰ��� ������ ����Ű�� �����ڵ�
	private Connection c;
	private User user;

	//���輳�� å�� �и����� ������
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = new DConnectionMaker();
	}

	public void add(User user) throws ClassNotFoundException, SQLException {

		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("insert into user (id, name, password) values(?,?,?)");

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {

		this.c = connectionMaker.makeConnection();

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