package com.hesshes.studytobe;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hesshes.studytobe.dao.ConnectionMaker;
import com.hesshes.studytobe.dao.DaoFactory;
import com.hesshes.studytobe.dao.NConnectionMaker;
import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list_1_40
public class executor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();

		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);

		System.out.println(dao1);
		System.out.println(dao2);
		System.out.println("==========================");
		System.out.println(dao3);
		System.out.println(dao4);
		
		User user = new User();
		user.setId("hesshes6");
		user.setName("ktaeu");
		user.setPassword("test");

		dao3.add(user);

		System.out.println(user.getId() + " 등록성공");

		User user2 = dao4.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회 성공");
		

	}
}
