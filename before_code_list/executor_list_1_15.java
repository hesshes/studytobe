package com.hesshes.studytobe;

import java.sql.SQLException;

import com.hesshes.studytobe.dao.ConnectionMaker;
import com.hesshes.studytobe.dao.DaoFactory;
import com.hesshes.studytobe.dao.NConnectionMaker;
import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list_1_15
public class executor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserDao dao = new DaoFactory().userDao();

		User user = new User();
		user.setId("hesshes2");
		user.setName("ktaeu");
		user.setPassword("test");

		dao.add(user);

		System.out.println(user.getId() + " 등록성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회 성공");

	}
}
