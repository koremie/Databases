package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.SoldDao;
import com.lviv.iot.domain.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SoldDaoImpl implements SoldDao {
    private static final String FIND_ALL = "SELECT * FROM sold";
    private static final String FIND_BY_ID = "SELECT * FROM sold WHERE id=?";
    private static final String CREATE = "INSERT INTO "
            + "sold (menu_vending_machine_id, menu_slot_number, time) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE sold SET "
            + "menu_vending_machine_id=?, menu_slot_number=?, time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sold WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sold> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Sold.class));
    }

    @Override
    public Optional<Sold> findById(Integer id) {
        Optional<Sold> sold;
        try {
            sold = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Sold.class), id));
        } catch (EmptyResultDataAccessException e) {
            sold = Optional.empty();
        }
        return sold;
    }

    @Override
    public int create(Sold sold) {
        return jdbcTemplate.update(CREATE, sold.getMenuVendingMachineId(), sold.getMenuSlotNumber(), sold.getTime());
    }

    @Override
    public int update(Integer id, Sold sold) {
        return jdbcTemplate.update(UPDATE, sold.getMenuVendingMachineId(), sold.getMenuSlotNumber(), sold.getTime(),
                id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
