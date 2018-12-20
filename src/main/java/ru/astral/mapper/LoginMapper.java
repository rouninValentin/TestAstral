package ru.astral.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.astral.model.Login;
import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {

        String userName = rs.getString("Username");
        String password = rs.getString("Password");

        return new Login(userName, password);
    }

}
