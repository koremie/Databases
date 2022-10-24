package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.SnackController;
import com.lviv.iot.domain.Snack;
import com.lviv.iot.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackControllerImpl implements SnackController {
    @Autowired
    private SnackService snackService;

    @Override
    public List<Snack> findAll() {
        return snackService.findAll();
    }

    @Override
    public Optional<Snack> findById(Integer id) {
        return snackService.findById(id);
    }

    @Override
    public int create(Snack snack) {
        return snackService.create(snack);
    }

    @Override
    public int update(Integer id, Snack snack) {
        return snackService.update(id, snack);
    }

    @Override
    public int delete(Integer id) {
        return snackService.delete(id);
    }
}