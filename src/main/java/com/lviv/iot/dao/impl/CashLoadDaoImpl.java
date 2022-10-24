package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.CashLoadDao;
import com.lviv.iot.domain.CashLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CashLoadDaoImpl implements CashLoadDao {
    private static final String FIND_ALL = "SELECT * FROM cash_load";
    private static final String FIND_BY_ID = "SELECT * FROM cash_load WHERE id=?";
    private static final String CREATE = "INSERT INTO "
            + "cash_load (vending_machine_id, service_staff_id, amount, date) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE cash_load SET "
            + "vending_machine_id=?, service_staff_id=?, amount=?, date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cash_load WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CashLoad> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CashLoad.class));
    }

    @Override
    public Optional<CashLoad> findById(Integer id) {
        Optional<CashLoad> cashLoad;
        try {
            cashLoad = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(CashLoad.class), id));
        } catch (EmptyResultDataAccessException e) {
            cashLoad = Optional.empty();
        }
        return cashLoad;
    }

    @Override
    public int create(CashLoad cashLoad) {
        return jdbcTemplate.update(CREATE, cashLoad.getVendingMachineId(), cashLoad.getServiceStaffId(),
                cashLoad.getAmount(), cashLoad.getDate());
    }

    @Override
    public int update(Integer id, CashLoad cashLoad) {
        return jdbcTemplate.update(UPDATE, cashLoad.getVendingMachineId(), cashLoad.getServiceStaffId(),
                cashLoad.getAmount(), cashLoad.getDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
