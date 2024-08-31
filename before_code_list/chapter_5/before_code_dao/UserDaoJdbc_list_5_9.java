package com.hesshes.studytobe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hesshes.studytobe.domain.Level;
import com.hesshes.studytobe.domain.User;

//list 5-9
public class UserDaoJdbc implements UserDao {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setLevel(Level.valueOf(rs.getInt("level")));
            user.setLogin(rs.getInt("login"));
            user.setRecoomend(rs.getInt("recommend"));
            return user;
        }
    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) {
        this.jdbcTemplate.update("insert into user(id, name, password, level, login, reccomend) values (?, ?, ?, ?, ?, ?)", user.getId(),
                user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecoomend());
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from user where id = ? ", new Object[] { id },
                this.userMapper);
    }

    // JdbcTemplate의 내장 콜백 사용
    public void deleteAll() { // throws SQLExeption 예외처리 삭제됨. 나중에 챕터 4에서 설명
        this.jdbcTemplate.update("delete from user");
    }

    // 2개의 콜백오브젝트 사용
    public int getCount() {
        return this.jdbcTemplate.queryForInt("select count(*) from user");
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from user order by id ", this.userMapper);
    }

}
