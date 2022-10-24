package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.MenuDao;
import com.lviv.iot.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuDaoImpl implements MenuDao {
    private static final String FIND_ALL = "SELECT * FROM menu";
    private static final String FIND_BY_ID = "SELECT * FROM menu WHERE vending_machine_id=? AND slot_number=?";
    private static final String CREATE = "INSERT INTO "
            + "menu (vending_machine_id, slot_number, snack_id, quantity, price_per_unit) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE menu SET "
            + "snack_id=?, quantity=?, price_per_unit=? WHERE vending_machine_id=? AND slot_number=?";
    private static final String DELETE = "DELETE FROM menu WHERE vending_machine_id=? AND slot_number=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Menu> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Menu.class));
    }

    @Override
    public Optional<Menu> findById(List<Integer> compositeKey) {
        Optional<Menu> menu;
        try {
            menu = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Menu.class), compositeKey.get(0), compositeKey.get(1)));
        } catch (EmptyResultDataAccessException e) {
            menu = Optional.empty();
        }
        return menu;
    }

    @Override
    public int create(Menu menu) {
        return jdbcTemplate.update(CREATE, menu.getVendingMachineId(), menu.getSlotNumber(), menu.getSnackId(),
                menu.getQuantity(), menu.getPricePerUnit());
    }

    @Override
    public int update(List<Integer> compositeKey, Menu menu) {
        return jdbcTemplate.update(UPDATE, menu.getSnackId(), menu.getQuantity(), menu.getPricePerUnit(),
                compositeKey.get(0), compositeKey.get(1));
    }

    @Override
    public int delete(List<Integer> compositeKey) {
        return jdbcTemplate.update(DELETE, compositeKey.get(0), compositeKey.get(1));
    }
}
