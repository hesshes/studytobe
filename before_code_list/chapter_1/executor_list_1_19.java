package com.hesshes.studytobe;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hesshes.studytobe.dao.ConnectionMaker;
import com.hesshes.studytobe.dao.DaoFactory;
import com.hesshes.studytobe.dao.NConnectionMaker;
import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list_1_19
public class executor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		//arg1 : @Bean 으로 등록된 이름
		//arg2 : return type class
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("hesshes3");
		user.setName("ktaeu3");
		user.setPassword("test3");

		dao.add(user);

		System.out.println(user.getId() + " 등록성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회 성공");

	}
}
