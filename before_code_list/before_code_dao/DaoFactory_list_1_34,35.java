package com.hesshes.studytobe.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//list 1-34, 35
@Configuration // application context or bean factory config info
public class DaoFactory {
	@Bean // object constructor	--> xml의 <bean> 태그
	public UserDao userDao() {	// 메소드 이름은 <bean id ="userDao" 
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;			// 리턴되는 클래스 정보 <bean class="com.hesshes.studytobe.UserDao" ㄴㄴㄴㄴ
	}

	@Bean
	public ConnectionMaker connectionMaker() {

		// 개발용인 경우 예시 코드
		// return new LocalDBConnectionMaker();

		// 운영용인 경우 예시 코드
		// return new ProductionDBConnectionMaker();
		return null;
	}
}
