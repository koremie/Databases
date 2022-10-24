package com.lviv.iot.service.impl;

import com.lviv.iot.dao.RestockDao;
import com.lviv.iot.domain.Restock;
import com.lviv.iot.service.RestockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestockServiceImpl implements RestockService {
    @Autowired
    private RestockDao restockDao;

    @Override
    public List<Restock> findAll() {
        return restockDao.findAll();
    }

    @Override
    public Optional<Restock> findById(Integer id) {
        return restockDao.findById(id);
    }

    @Override
    public int create(Restock restock) {
        return restockDao.create(restock);
    }

    @Override
    public int update(Integer id, Restock restock) {
        return restockDao.update(id, restock);
    }

    @Override
    public int delete(Integer id) {
        return restockDao.delete(id);
    }
}