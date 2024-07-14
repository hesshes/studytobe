package com.hesshes.studytobe.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//list 1-18
@Configuration // application context or bean factory config info
public class DaoFactory {
	@Bean // object constructor
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
