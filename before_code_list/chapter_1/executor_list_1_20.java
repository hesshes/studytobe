package com.hesshes.studytobe;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hesshes.studytobe.dao.ConnectionMaker;
import com.hesshes.studytobe.dao.DaoFactory;
import com.hesshes.studytobe.dao.NConnectionMaker;
import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list_1_20
public class executor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();

		System.out.println(dao1);
		System.out.println(dao2);

	}
}
