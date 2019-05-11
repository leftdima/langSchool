package com.baranchik.service;

import com.baranchik.model.Address;
import com.baranchik.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User authoriseUser(String login, String password);
    User getById(Integer id);
    void saveUser(User user);
    void saveAddress(Address address);
    User getByLogin(String login);
}
