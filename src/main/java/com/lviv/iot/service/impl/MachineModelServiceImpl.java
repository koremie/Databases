package com.lviv.iot.service.impl;

import com.lviv.iot.dao.MachineModelDao;
import com.lviv.iot.domain.MachineModel;
import com.lviv.iot.service.MachineModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineModelServiceImpl implements MachineModelService {
    @Autowired
    private MachineModelDao machineModelDao;

    @Override
    public List<MachineModel> findAll() {
        return machineModelDao.findAll();
    }

    @Override
    public Optional<MachineModel> findById(String name) {
        return machineModelDao.findById(name);
    }

    @Override
    public int create(MachineModel machineModel) {
        return machineModelDao.create(machineModel);
    }

    @Override
    public int update(String name, MachineModel machineModel) {
        return machineModelDao.update(name, machineModel);
    }

    @Override
    public int delete(String name) {
        return machineModelDao.delete(name);
    }
}