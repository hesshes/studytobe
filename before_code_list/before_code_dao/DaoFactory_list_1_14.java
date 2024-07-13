package com.hesshes.studytobe.dao;

//list 1-14
public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
}
