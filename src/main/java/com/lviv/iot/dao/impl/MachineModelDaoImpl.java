package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.MachineModelDao;
import com.lviv.iot.domain.MachineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineModelDaoImpl implements MachineModelDao {
    private static final String FIND_ALL = "SELECT * FROM machine_model";
    private static final String FIND_BY_ID = "SELECT * FROM machine_model WHERE name=?";
    private static final String CREATE = "INSERT INTO machine_model (name, company) VALUES (?,?)";
    private static final String UPDATE = "UPDATE machine_model SET name=?, company=? WHERE name=?";
    private static final String DELETE = "DELETE FROM machine_model WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MachineModel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(MachineModel.class));
    }

    @Override
    public Optional<MachineModel> findById(String name) {
        Optional<MachineModel> machineModel;
        try {
            machineModel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(MachineModel.class), name));
        } catch (EmptyResultDataAccessException e) {
            machineModel = Optional.empty();
        }
        return machineModel;
    }

    @Override
    public int create(MachineModel machineModel) {
        return jdbcTemplate.update(CREATE, machineModel.getName(), machineModel.getCompany());
    }

    @Override
    public int update(String name, MachineModel machineModel) {
        return jdbcTemplate.update(UPDATE, machineModel.getName(), machineModel.getCompany(), name);
    }

    @Override
    public int delete(String name) {
        return jdbcTemplate.update(DELETE, name);
    }
}
