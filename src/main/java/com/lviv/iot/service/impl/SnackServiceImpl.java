package com.lviv.iot.service.impl;

import com.lviv.iot.dao.SnackDao;
import com.lviv.iot.domain.Snack;
import com.lviv.iot.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackServiceImpl implements SnackService {
    @Autowired
    private SnackDao snackDao;

    @Override
    public List<Snack> findAll() {
        return snackDao.findAll();
    }

    @Override
    public Optional<Snack> findById(Integer id) {
        return snackDao.findById(id);
    }

    @Override
    public int create(Snack snack) {
        return snackDao.create(snack);
    }

    @Override
    public int update(Integer id, Snack snack) {
        return snackDao.update(id, snack);
    }

    @Override
    public int delete(Integer id) {
        return snackDao.delete(id);
    }
}