package ru.astral.dao;

import java.util.List;

import ru.astral.model.Login;
import ru.astral.model.User;

public interface LoginDAO {

    void register(User user);

    User validateUser(Login login);


    public Login findLogin(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);

}