package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.MachineModelController;
import com.lviv.iot.domain.MachineModel;
import com.lviv.iot.service.MachineModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineModelControllerImpl implements MachineModelController {
    @Autowired
    private MachineModelService machineModelService;

    @Override
    public List<MachineModel> findAll() {
        return machineModelService.findAll();
    }

    @Override
    public Optional<MachineModel> findById(String name) {
        return machineModelService.findById(name);
    }

    @Override
    public int create(MachineModel machineModel) {
        return machineModelService.create(machineModel);
    }

    @Override
    public int update(String name, MachineModel machineModel) {
        return machineModelService.update(name, machineModel);
    }

    @Override
    public int delete(String name) {
        return machineModelService.delete(name);
    }
}