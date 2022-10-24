package com.lviv.iot.service.impl;

import com.lviv.iot.dao.ServiceStaffDao;
import com.lviv.iot.domain.ServiceStaff;
import com.lviv.iot.service.ServiceStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStaffServiceImpl implements ServiceStaffService {
    @Autowired
    private ServiceStaffDao serviceStaffDao;

    @Override
    public List<ServiceStaff> findAll() {
        return serviceStaffDao.findAll();
    }

    @Override
    public Optional<ServiceStaff> findById(Integer id) {
        return serviceStaffDao.findById(id);
    }

    @Override
    public int create(ServiceStaff serviceStaff) {
        return serviceStaffDao.create(serviceStaff);
    }

    @Override
    public int update(Integer id, ServiceStaff serviceStaff) {
        return serviceStaffDao.update(id, serviceStaff);
    }

    @Override
    public int delete(Integer id) {
        return serviceStaffDao.delete(id);
    }
}