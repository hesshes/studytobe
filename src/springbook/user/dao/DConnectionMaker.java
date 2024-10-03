package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://121.162.161.70:60335/tobe?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
                "tobe", "t@eWoo0151");
        return c;
    }
}
