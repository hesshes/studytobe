package com.hesshes.studytobe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hesshes.studytobe.dao.CountingConnectionMaker;
import com.hesshes.studytobe.dao.CountingDaoFactory;
import com.hesshes.studytobe.dao.UserDao;

// list 1-32
public class UserDaoConnectionCountingTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);

		UserDao dao = context.getBean("userDao", UserDao.class);

		//
		// DAO 사용 코드
		//
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());

	}

}
