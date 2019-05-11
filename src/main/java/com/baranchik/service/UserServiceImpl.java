package com.baranchik.service;

import com.baranchik.model.Address;
import com.baranchik.model.User;
import com.baranchik.repository.AddressRepository;
import com.baranchik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.getUserList();
    }

    @Override
    @Transactional
    public User authoriseUser(String login, String password) {
        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Override
    @Transactional
    public User getById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public void saveAddress(Address address) {
        addressRepository.addAddress(address);
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
