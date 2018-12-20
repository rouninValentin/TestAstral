package ru.astral.service;

import org.springframework.beans.factory.annotation.Autowired;

import ru.astral.dao.LoginDAO;
import ru.astral.model.Login;
import ru.astral.model.User;

public class UserServiceImpl implements UserService {

    @Autowired
    public LoginDAO loginDao;

    public void register(User user) {
        loginDao.register(user);
    }

    public User validateUser(Login login) {
        return loginDao.validateUser(login);
    }

}