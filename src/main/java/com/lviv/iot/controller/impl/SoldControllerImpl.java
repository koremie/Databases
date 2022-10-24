package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.SoldController;
import com.lviv.iot.domain.Sold;
import com.lviv.iot.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldControllerImpl implements SoldController {
    @Autowired
    private SoldService soldService;

    @Override
    public List<Sold> findAll() {
        return soldService.findAll();
    }

    @Override
    public Optional<Sold> findById(Integer id) {
        return soldService.findById(id);
    }

    @Override
    public int create(Sold sold) {
        return soldService.create(sold);
    }

    @Override
    public int update(Integer id, Sold sold) {
        return soldService.update(id, sold);
    }

    @Override
    public int delete(Integer id) {
        return soldService.delete(id);
    }
}