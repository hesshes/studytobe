package com.hesshes.studytobe.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//list 1-28, list 1-29
@Configuration // application context or bean factory config info
public class DaoFactory {
	@Bean // object constructor
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {

		// ���߿��� ��� ���� �ڵ�
		// return new LocalDBConnectionMaker();

		// ����� ��� ���� �ڵ�
		// return new ProductionDBConnectionMaker();
		return null;
	}
}
