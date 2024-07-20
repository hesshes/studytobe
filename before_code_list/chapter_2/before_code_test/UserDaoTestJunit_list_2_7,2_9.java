package com.hesshes.studytobe;

import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list 2-7, 2-9
public class UserDaoTestJunit {

	@Test
	public void addAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		User user = new User();
		user.setId("junit1");
		user.setName("test1");
		user.setPassword("junit1");

		dao.add(user);
		assertThat(dao.getCount(), is(1));

		User user2 = dao.get(user.getId());

		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}

}
