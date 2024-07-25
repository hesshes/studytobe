package com.hesshes.studytobe;

import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.User;

//list 2-23
//application Context 가 없는 di 테스트
public class UserDaoTestJunit {

    private UserDao dao;

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {

        dao = new UserDao();
        
        this.user1 = new User("junit2", "test2", "test2");
        this.user2 = new User("junit3", "test3", "test3");
        this.user3 = new User("junit4", "test4", "test4");
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:mysql://localhost:3306/tobe?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "tobe",
                "tobe", true);

        dao.setDataSource(dataSource);
    }

    @Test
    public void count() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test
    public void addAndGet() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user1 = new User("junit4", "test4", "test4");
        User user2 = new User("junit5", "test5", "test5");

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknow_id");
    }
}
