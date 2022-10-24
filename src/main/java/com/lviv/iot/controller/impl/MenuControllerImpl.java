package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.MenuController;
import com.lviv.iot.domain.Menu;
import com.lviv.iot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuControllerImpl implements MenuController {
    @Autowired
    private MenuService menuService;

    @Override
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @Override
    public Optional<Menu> findById(List<Integer> compositeKey) {
        return menuService.findById(compositeKey);
    }

    @Override
    public int create(Menu menu) {
        return menuService.create(menu);
    }

    @Override
    public int update(List<Integer> compositeKey, Menu menu) {
        return menuService.update(compositeKey, menu);
    }

    @Override
    public int delete(List<Integer> compositeKey) {
        return menuService.delete(compositeKey);
    }
}