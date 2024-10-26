package springbook.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import springbook.user.dao.CountingConnectionMaker;
import springbook.user.dao.CountingDaoFactory;
import springbook.user.dao.UserDao;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = ctx.getBean("userDao", UserDao.class);


        CountingConnectionMaker ccm = ctx.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());

    }

}
