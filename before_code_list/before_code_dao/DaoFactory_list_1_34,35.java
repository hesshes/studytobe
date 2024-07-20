package com.hesshes.studytobe.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//list 1-34, 35
@Configuration // application context or bean factory config info
public class DaoFactory {
	@Bean // object constructor	--> xml�� <bean> �±�
	public UserDao userDao() {	// �޼ҵ� �̸��� <bean id ="userDao" 
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;			// ���ϵǴ� Ŭ���� ���� <bean class="com.hesshes.studytobe.UserDao" ��������
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
