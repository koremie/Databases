package com.lviv.iot.service.impl;

import com.lviv.iot.dao.CashLoadDao;
import com.lviv.iot.domain.CashLoad;
import com.lviv.iot.service.CashLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashLoadServiceImpl implements CashLoadService {
    @Autowired
    private CashLoadDao cashLoadDao;

    @Override
    public List<CashLoad> findAll() {
        return cashLoadDao.findAll();
    }

    @Override
    public Optional<CashLoad> findById(Integer id) {
        return cashLoadDao.findById(id);
    }

    @Override
    public int create(CashLoad cashLoad) {
        return cashLoadDao.create(cashLoad);
    }

    @Override
    public int update(Integer id, CashLoad cashLoad) {
        return cashLoadDao.update(id, cashLoad);
    }

    @Override
    public int delete(Integer id) {
        return cashLoadDao.delete(id);
    }
}