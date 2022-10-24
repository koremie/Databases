package com.lviv.iot.service.impl;

import com.lviv.iot.dao.MenuDao;
import com.lviv.iot.domain.Menu;
import com.lviv.iot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    @Override
    public Optional<Menu> findById(List<Integer> compositeKey) {
        return menuDao.findById(compositeKey);
    }

    @Override
    public int create(Menu menu) {
        return menuDao.create(menu);
    }

    @Override
    public int update(List<Integer> compositeKey, Menu menu) {
        return menuDao.update(compositeKey, menu);
    }

    @Override
    public int delete(List<Integer> compositeKey) {
        return menuDao.delete(compositeKey);
    }
}