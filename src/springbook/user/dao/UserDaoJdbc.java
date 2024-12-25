package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.exception.DuplicateUserIdException;

//import org.springframework.dao.DataAccessException;
//import com.mysql.cj.exceptions.MysqlErrorNumbers;
//import springbook.exception.DuplicateUserIdException;

import springbook.user.domain.User;

public class UserDaoJdbc implements UserDao {

    private JdbcTemplate jdbcTemplate;
//    private DataSource dataSource;
//    private Connection c;
//    private PreparedStatement ps;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        // this.dataSource = dataSource;
    }

    private RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    public void add(final User user) throws DuplicateKeyException {
        // public void add(final User user) throws SQLException,
        // DuplicateUserIdException {
        try {
            this.jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)", user.getId(),
                    user.getName(), user.getPassword());
        } catch (DuplicateKeyException e) {
            throw new DuplicateUserIdException(e);
        }

//        try {
//            this.c = dataSource.getConnection();
//            this.ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
//            ps.setString(1, user.getId());
//            ps.setString(2, user.getName());
//            ps.setString(3, user.getPassword());
//
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
//                throw new DuplicateUserIdException(e);
//            else
//                throw new RuntimeException(e);
//        } finally {
//            if(this.ps !=null)
//                this.ps.close();
//            if(this.c !=null)
//                this.c.close();
//        }

    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ? ", new Object[] { id },
                this.userMapper);
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForInt("select count(*) from users");
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id", this.userMapper);
    }

}
