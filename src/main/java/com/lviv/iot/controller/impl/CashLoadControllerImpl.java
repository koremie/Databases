package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.CashLoadController;
import com.lviv.iot.domain.CashLoad;
import com.lviv.iot.service.CashLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashLoadControllerImpl implements CashLoadController {
    @Autowired
    private CashLoadService cashLoadService;

    @Override
    public List<CashLoad> findAll() {
        return cashLoadService.findAll();
    }

    @Override
    public Optional<CashLoad> findById(Integer id) {
        return cashLoadService.findById(id);
    }

    @Override
    public int create(CashLoad cashLoad) {
        return cashLoadService.create(cashLoad);
    }

    @Override
    public int update(Integer id, CashLoad cashLoad) {
        return cashLoadService.update(id, cashLoad);
    }

    @Override
    public int delete(Integer id) {
        return cashLoadService.delete(id);
    }
}