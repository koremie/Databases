package com.lviv.iot.service.impl;

import com.lviv.iot.dao.AddressDao;
import com.lviv.iot.domain.Address;
import com.lviv.iot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressDao.findById(id);
    }

    @Override
    public int create(Address address) {
        return addressDao.create(address);
    }

    @Override
    public int update(Integer id, Address address) {
        return addressDao.update(id, address);
    }

    @Override
    public int delete(Integer id) {
        return addressDao.delete(id);
    }
}