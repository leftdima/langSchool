package com.baranchik.repository;

import com.baranchik.model.User;

import java.util.List;


public interface UserRepository {
    List getUserList();
    User getUserByLoginAndPassword(String login, String password);
    User getUserById(Integer id);
    void saveUser(User user);
    User getUserByLogin(String login);
}
