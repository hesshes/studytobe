package springbook.test;

import java.sql.SQLException;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("��⼱");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " ��� ���� ");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " ��ȸ ����");

    }

}
