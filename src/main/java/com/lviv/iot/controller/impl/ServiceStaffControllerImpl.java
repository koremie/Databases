package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.ServiceStaffController;
import com.lviv.iot.domain.ServiceStaff;
import com.lviv.iot.service.ServiceStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStaffControllerImpl implements ServiceStaffController {
    @Autowired
    private ServiceStaffService serviceStaffService;

    @Override
    public List<ServiceStaff> findAll() {
        return serviceStaffService.findAll();
    }

    @Override
    public Optional<ServiceStaff> findById(Integer id) {
        return serviceStaffService.findById(id);
    }

    @Override
    public int create(ServiceStaff serviceStaff) {
        return serviceStaffService.create(serviceStaff);
    }

    @Override
    public int update(Integer id, ServiceStaff serviceStaff) {
        return serviceStaffService.update(id, serviceStaff);
    }

    @Override
    public int delete(Integer id) {
        return serviceStaffService.delete(id);
    }
}