package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.VendingMachineController;
import com.lviv.iot.domain.VendingMachine;
import com.lviv.iot.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineControllerImpl implements VendingMachineController {
    @Autowired
    private VendingMachineService vendingMachineService;

    @Override
    public List<VendingMachine> findAll() {
        return vendingMachineService.findAll();
    }

    @Override
    public Optional<VendingMachine> findById(Integer id) {
        return vendingMachineService.findById(id);
    }

    @Override
    public int create(VendingMachine vendingMachine) {
        return vendingMachineService.create(vendingMachine);
    }

    @Override
    public int update(Integer id, VendingMachine vendingMachine) {
        return vendingMachineService.update(id, vendingMachine);
    }

    @Override
    public int delete(Integer id) {
        return vendingMachineService.delete(id);
    }
}