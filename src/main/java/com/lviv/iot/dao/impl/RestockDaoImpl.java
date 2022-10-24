package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.RestockDao;
import com.lviv.iot.domain.Restock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestockDaoImpl implements RestockDao {
    private static final String FIND_ALL = "SELECT * FROM restock";
    private static final String FIND_BY_ID = "SELECT * FROM restock WHERE id=?";
    private static final String CREATE = "INSERT INTO "
            + "restock (menu_vending_machine_id, menu_slot_number, quantity, service_staff_id, date) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE restock SET "
            + "menu_vending_machine_id=?, menu_slot_number=?, quantity=?, service_staff_id=?, date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM restock WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Restock> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Restock.class));
    }

    @Override
    public Optional<Restock> findById(Integer id) {
        Optional<Restock> restock;
        try {
            restock = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Restock.class), id));
        } catch (EmptyResultDataAccessException e) {
            restock = Optional.empty();
        }
        return restock;
    }

    @Override
    public int create(Restock restock) {
        return jdbcTemplate.update(CREATE, restock.getMenuVendingMachineId(), restock.getMenuSlotNumber(),
                restock.getQuantity(), restock.getServiceStaffId(), restock.getDate());
    }

    @Override
    public int update(Integer id, Restock restock) {
        return jdbcTemplate.update(UPDATE, restock.getMenuVendingMachineId(), restock.getMenuSlotNumber(),
                restock.getQuantity(), restock.getServiceStaffId(), restock.getDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
