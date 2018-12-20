package ru.astral.service;

import ru.astral.model.Login;
import ru.astral.model.User;

public interface UserService {

    void register(User user);

    User validateUser(Login login);
}