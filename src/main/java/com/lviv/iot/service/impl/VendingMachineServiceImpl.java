package com.lviv.iot.service.impl;

import com.lviv.iot.dao.VendingMachineDao;
import com.lviv.iot.domain.VendingMachine;
import com.lviv.iot.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {
    @Autowired
    private VendingMachineDao vendingMachineDao;

    @Override
    public List<VendingMachine> findAll() {
        return vendingMachineDao.findAll();
    }

    @Override
    public Optional<VendingMachine> findById(Integer id) {
        return vendingMachineDao.findById(id);
    }

    @Override
    public int create(VendingMachine vendingMachine) {
        return vendingMachineDao.create(vendingMachine);
    }

    @Override
    public int update(Integer id, VendingMachine vendingMachine) {
        return vendingMachineDao.update(id, vendingMachine);
    }

    @Override
    public int delete(Integer id) {
        return vendingMachineDao.delete(id);
    }
}