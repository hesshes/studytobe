package com.hesshes.studytobe.dao;

//list 1-16
//ConnectionMaker �ڵ� �ߺ�����
public class DaoFactory {
	public UserDao userDao() {
		UserDao userDao = new UserDao(new DConnectionMaker());
		return userDao;
	}

	public UserDao accountDao() {
		UserDao userDao = new UserDao(new DConnectionMaker());
		return userDao;
	}
	
	public UserDao messageDao() {
		UserDao userDao = new UserDao(new DConnectionMaker());
		return userDao;
	}
}
