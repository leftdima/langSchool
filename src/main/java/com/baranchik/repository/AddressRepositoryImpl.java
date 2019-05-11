package com.baranchik.repository;

import com.baranchik.model.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl implements AddressRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAddress(Address address) {
        sessionFactory.getCurrentSession().saveOrUpdate(address);
    }
}
