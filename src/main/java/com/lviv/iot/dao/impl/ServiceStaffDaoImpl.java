package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.ServiceStaffDao;
import com.lviv.iot.domain.ServiceStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiceStaffDaoImpl implements ServiceStaffDao {
    private static final String FIND_ALL = "SELECT * FROM service_staff";
    private static final String FIND_BY_ID = "SELECT * FROM service_staff WHERE id=?";
    private static final String CREATE = "INSERT INTO "
            + "service_staff (name, last_name, work_experience, is_available, address_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE service_staff SET "
            + "name=?, last_name=?, work_experience=?, is_available=?, address_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM service_staff WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ServiceStaff> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ServiceStaff.class));
    }

    @Override
    public Optional<ServiceStaff> findById(Integer id) {
        Optional<ServiceStaff> serviceStaff;
        try {
            serviceStaff = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(ServiceStaff.class), id));
        } catch (EmptyResultDataAccessException e) {
            serviceStaff = Optional.empty();
        }
        return serviceStaff;
    }

    @Override
    public int create(ServiceStaff serviceStaff) {
        return jdbcTemplate.update(CREATE, serviceStaff.getName(), serviceStaff.getLastName(),
                serviceStaff.getWorkExperience(), (serviceStaff.getIsAvailable() ? 1 : 0), serviceStaff.getAddressId());
    }

    @Override
    public int update(Integer id, ServiceStaff serviceStaff) {
        return jdbcTemplate.update(UPDATE, serviceStaff.getName(), serviceStaff.getLastName(),
                serviceStaff.getWorkExperience(), serviceStaff.getIsAvailable(), serviceStaff.getAddressId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
