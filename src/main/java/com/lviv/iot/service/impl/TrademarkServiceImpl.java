package com.lviv.iot.service.impl;

import com.lviv.iot.dao.TrademarkDao;
import com.lviv.iot.domain.Trademark;
import com.lviv.iot.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrademarkServiceImpl implements TrademarkService {
    @Autowired
    private TrademarkDao trademarkDao;

    @Override
    public List<Trademark> findAll() {
        return trademarkDao.findAll();
    }

    @Override
    public Optional<Trademark> findById(String name) {
        return trademarkDao.findById(name);
    }

    @Override
    public int create(Trademark machineModel) {
        return trademarkDao.create(machineModel);
    }

    @Override
    public int update(String name, Trademark machineModel) {
        return trademarkDao.update(name, machineModel);
    }

    @Override
    public int delete(String name) {
        return trademarkDao.delete(name);
    }
}