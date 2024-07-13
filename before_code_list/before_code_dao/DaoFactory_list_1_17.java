package com.hesshes.studytobe.dao;

//list 1-17
public class DaoFactory {
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	public UserDao accountDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	public UserDao messageDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	// list 1-16 �ߺ� ���Ÿ� ���� �и��� �ڵ�
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
