package com.hesshes.studytobe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hesshes.studytobe.domain.User;

//list 3-55, 56, 57, 58 ( 최종 UserDao )
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) throws SQLException {
        this.jdbcTemplate.update("insert into user(id, name, password) values (?, ?, ?)", user.getId(), user.getName(),
                user.getPassword());
    }

    public User get(String id) throws SQLException {
        return this.jdbcTemplate.queryForObject("select * from user where id = ? ", new Object[] { id },
                this.userMapper);
    }

    // JdbcTemplate의 내장 콜백 사용
    public void deleteAll() throws SQLException {
        this.jdbcTemplate.update("delete from user");
    }

    // 2개의 콜백오브젝트 사용
    public int getCount() throws SQLException {
        return this.jdbcTemplate.queryForInt("select count(*) from user");
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from user order by id ", this.userMapper);
    }
}
