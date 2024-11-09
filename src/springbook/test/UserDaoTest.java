package springbook.test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private ApplicationContext ctx;
    private UserDao dao;

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        System.out.println(this.ctx);
        System.out.println(this);
        this.dao = this.ctx.getBean("userDao", UserDao.class);
        this.user1 = new User("tester1", "pass1", "�׽���1");
        this.user2 = new User("tester2", "pass2", "�׽���2");
        this.user3 = new User("tester3", "pass3", "�׽���3");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        dao.delteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userGet1 = dao.get(user1.getId());
        User userGet2 = dao.get(user2.getId());

        assertThat(userGet1.getName(), is(user1.getName()));
        assertThat(user1.getName(), is(userGet1.getName()));

        assertThat(userGet2.getName(), is(user2.getName()));
        assertThat(user2.getName(), is(userGet2.getName()));

    }

    @Test
    public void getCount() throws SQLException, ClassNotFoundException {
        dao.delteAll();
        assertThat(dao.getCount(), is(0));

        User user1 = new User("tester1", "pass1", "�׽���1");
        User user2 = new User("tester2", "pass2", "�׽���2");
        User user3 = new User("tester3", "pass3", "�׽���3");

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        dao.delteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }

}
