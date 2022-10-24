package com.lviv.iot.service.impl;

import com.lviv.iot.dao.SoldDao;
import com.lviv.iot.domain.Sold;
import com.lviv.iot.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldServiceImpl implements SoldService {
    @Autowired
    private SoldDao soldDao;

    @Override
    public List<Sold> findAll() {
        return soldDao.findAll();
    }

    @Override
    public Optional<Sold> findById(Integer id) {
        return soldDao.findById(id);
    }

    @Override
    public int create(Sold sold) {
        return soldDao.create(sold);
    }

    @Override
    public int update(Integer id, Sold sold) {
        return soldDao.update(id, sold);
    }

    @Override
    public int delete(Integer id) {
        return soldDao.delete(id);
    }
}