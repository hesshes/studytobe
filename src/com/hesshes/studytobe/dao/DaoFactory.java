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

	// list 1-16 중복 제거를 위해 분리한 코드
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
