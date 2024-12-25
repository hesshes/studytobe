package springbook.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import springbook.user.dao.CountingConnectionMaker;
import springbook.user.dao.CountingDaoFactory;
import springbook.user.dao.UserDaoJdbc;
import springbook.user.domain.User;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDaoJdbc dao = ctx.getBean("userDao", UserDaoJdbc.class);

        User user = new User();
        user.setId("whiteship2");
        user.setName("��⼱");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " ��� ���� ");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " ��ȸ ����");
        CountingConnectionMaker ccm = ctx.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());

    }

}
