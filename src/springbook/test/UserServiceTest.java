package springbook.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import springbook.exception.TestUserServiceException;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;
import springbook.user.service.UserLevelUpgradePolicy;
import springbook.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao dao;

    @Autowired
    DataSource dataSource;

    @Autowired
    PlatformTransactionManager transactionManager;
    
    @Autowired
    MailSender mailSender;
    

    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, UserLevelUpgradePolicy.MIN_LOGCOUNT_FOR_SILVER - 1, 0,
                        "bumjin@email.com"),
                new User("joytouch", "강명성", "p2", Level.BASIC, UserLevelUpgradePolicy.MIN_LOGCOUNT_FOR_SILVER, 0,
                        "joytouch@email.com"),
                new User("erwins", "신승환", "p3", Level.SILVER, UserLevelUpgradePolicy.MIN_LOGCOUNT_FOR_SILVER + 30,
                        UserLevelUpgradePolicy.MIN_RECCOMENT_FOR_GOLD - 1, "erwins@email.com"),
                new User("madnite1", "이상호", "p4", Level.SILVER, UserLevelUpgradePolicy.MIN_LOGCOUNT_FOR_SILVER + 30,
                        UserLevelUpgradePolicy.MIN_RECCOMENT_FOR_GOLD, "madnite1@email.com"),
                new User("green", "오민규", "p5", Level.GOLD, UserLevelUpgradePolicy.MIN_LOGCOUNT_FOR_SILVER + 70,
                        Integer.MAX_VALUE, "green@email.com"));
    }

    @Test
    public void bean() {
        assertThat(this.userService, is(notNullValue()));
    }

    @Test
    public void add() {
        dao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = dao.get(userWithLevel.getId());
        User userWithoutLevelRead = dao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
        assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
    }

    @Test
    public void upgradeLevels() throws Exception {
        dao.deleteAll();
        for (User user : users) {
            dao.add(user);
        }

        userService.upgradeLevels();

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);

    }

    @Test
    public void upgradeAllOrNothing() throws Exception {
        UserService testUserService = new TestUserService(users.get(3).getId());
        testUserService.setUserDao(this.dao);
        testUserService.setTransactionManager(this.transactionManager);
        testUserService.setMailSender(mailSender);

        dao.deleteAll();
        for (User user : users)
            dao.add(user);

        try {
            testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (TestUserServiceException e) {

        }
        checkLevelUpgraded(users.get(1), false);
    }

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = dao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(user.getLevel()));
        }
    }

    static class TestUserService extends UserService {
        private String id;

        private TestUserService(String id) {
            this.id = id;
        }

        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id))
                throw new TestUserServiceException();
            super.upgradeLevel(user);
        }
    }
}
