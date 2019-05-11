package com.baranchik.repository;

import com.baranchik.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository  {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUserList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User")
                .list();
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return (User)sessionFactory
                .getCurrentSession()
                .createQuery("from User where login =:userLogin and password=:userPassword")
                .setString("userLogin", login)
                .setString("userPassword", password)
                .uniqueResult();
    }

    @Override
    public User getUserById(Integer id) {
        return (User)sessionFactory
                .getCurrentSession()
                .createQuery("from User where id =:userId")
                .setInteger("userId", id)
                .uniqueResult();
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return (User)sessionFactory
                .getCurrentSession()
                .createQuery("from User where login =:userLogin")
                .setString("userLogin", login)
                .uniqueResult();
    }
}
