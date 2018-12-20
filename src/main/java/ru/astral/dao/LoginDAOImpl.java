package ru.astral.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.astral.mapper.LoginMapper;
import ru.astral.mapper.UserMapper;
import ru.astral.model.Login;
import ru.astral.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginDAOImpl extends JdbcDaoSupport implements LoginDAO {

    @Autowired
    public LoginDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void register(User user) {
        String sql = "insert into users values(?,?)";
        jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword() });
    }
    public User validateUser(Login login) {
        String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public Login findLogin(String userName) {
        String sql = "Select u.Username,u.Password "//
                + " from Users u where u.Username = ? ";

        Object[] params = new Object[] { userName };
        LoginMapper mapper = new LoginMapper();
        try {
            Login login = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return login;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.User_Role "//
                + " from User_Roles r where r.Username = ? ";

        Object[] params = new Object[] { userName };

        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);

        return roles;
    }

}