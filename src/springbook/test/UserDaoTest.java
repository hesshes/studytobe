package springbook.test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {
    
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = ctx.getBean("userDao", UserDao.class);
        
        User user = new User();
        user.setId("whiteship4");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);


        User user2 = dao.get(user.getId());
        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

        System.out.println(user2.getId() + " 조회 성공");
    }

}
