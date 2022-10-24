package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.RestockController;
import com.lviv.iot.domain.Restock;
import com.lviv.iot.service.RestockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestockControllerImpl implements RestockController {
    @Autowired
    private RestockService restockService;

    @Override
    public List<Restock> findAll() {
        return restockService.findAll();
    }

    @Override
    public Optional<Restock> findById(Integer id) {
        return restockService.findById(id);
    }

    @Override
    public int create(Restock restock) {
        return restockService.create(restock);
    }

    @Override
    public int update(Integer id, Restock restock) {
        return restockService.update(id, restock);
    }

    @Override
    public int delete(Integer id) {
        return restockService.delete(id);
    }
}