package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.AddressController;
import com.lviv.iot.domain.Address;
import com.lviv.iot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressControllerImpl implements AddressController {
    @Autowired
    private AddressService addressService;

    @Override
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressService.findById(id);
    }

    @Override
    public int create(Address address) {
        return addressService.create(address);
    }

    @Override
    public int update(Integer id, Address address) {
        return addressService.update(id, address);
    }

    @Override
    public int delete(Integer id) {
        return addressService.delete(id);
    }
}