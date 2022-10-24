package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.TrademarkController;
import com.lviv.iot.domain.Trademark;
import com.lviv.iot.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrademarkControllerImpl implements TrademarkController {
    @Autowired
    private TrademarkService trademarkService;

    @Override
    public List<Trademark> findAll() {
        return trademarkService.findAll();
    }

    @Override
    public Optional<Trademark> findById(String name) {
        return trademarkService.findById(name);
    }

    @Override
    public int create(Trademark machineModel) {
        return trademarkService.create(machineModel);
    }

    @Override
    public int update(String name, Trademark machineModel) {
        return trademarkService.update(name, machineModel);
    }

    @Override
    public int delete(String name) {
        return trademarkService.delete(name);
    }
}