package com.hesshes.studytobe.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;

import com.hesshes.studytobe.dao.UserDao;
import com.hesshes.studytobe.domain.Level;
import com.hesshes.studytobe.domain.User;
import com.hesshes.studytobe.service.UserService;
import static com.hesshes.studytobe.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static com.hesshes.studytobe.service.UserService.MIN_RECOMMEND_FOR_GOLD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
//list 5-32
public class UserSerivceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(new User("test1", "tester1", "t1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("test2", "tester2", "t2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("test3", "tester3", "t3", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
                new User("test4", "tester4", "t4", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
                new User("test5", "tester5", "t5", Level.GOLD, 100, Integer.MAX_VALUE)

        );
    }

    @Test
    public void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
        assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));

    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        userService.upgradeLevels();

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);

    }


    private void checkLevelUpgraded(User user, boolean upgraded) {

        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(user.getLevel()));
        }
    }

}
