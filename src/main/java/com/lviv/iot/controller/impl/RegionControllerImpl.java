package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.RegionController;
import com.lviv.iot.domain.Region;
import com.lviv.iot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionControllerImpl implements RegionController {
    @Autowired
    private RegionService regionService;

    @Override
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return regionService.findById(id);
    }

    @Override
    public int create(Region region) {
        return regionService.create(region);
    }

    @Override
    public int update(Integer id, Region region) {
        return regionService.update(id, region);
    }

    @Override
    public int delete(Integer id) {
        return regionService.delete(id);
    }
}