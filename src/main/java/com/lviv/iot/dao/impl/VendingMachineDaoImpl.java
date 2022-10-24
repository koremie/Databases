package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.VendingMachineDao;
import com.lviv.iot.domain.VendingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VendingMachineDaoImpl implements VendingMachineDao {
    private static final String FIND_ALL = "SELECT * FROM vending_machine";
    private static final String FIND_BY_ID = "SELECT * FROM vending_machine WHERE id=?";
    private static final String CREATE = "INSERT INTO vending_machine "
            + "(machine_model_name, gps, address_id, contact_number, is_out_of_order, is_empty) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE vending_machine SET "
            + "machine_model_name=?, gps=?, address_id=?, contact_number=?, is_out_of_order=?, is_empty=? WHERE id=?";
    private static final String DELETE = "DELETE FROM vending_machine WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VendingMachine> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(VendingMachine.class));
    }

    @Override
    public Optional<VendingMachine> findById(Integer id) {
        Optional<VendingMachine> vendingMachine;
        try {
            vendingMachine = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(VendingMachine.class), id));
        } catch (EmptyResultDataAccessException e) {
            vendingMachine = Optional.empty();
        }
        return vendingMachine;
    }

    @Override
    public int create(VendingMachine vendingMachine) {
        return jdbcTemplate.update(CREATE, vendingMachine.getMachineModelName(), vendingMachine.getGPS(),
                vendingMachine.getAddressId(), vendingMachine.getContactNumber(), vendingMachine.getIsOutOfOrder(),
                vendingMachine.getIsEmpty());
    }

    @Override
    public int update(Integer id, VendingMachine vendingMachine) {
        return jdbcTemplate.update(UPDATE, vendingMachine.getMachineModelName(), vendingMachine.getGPS(),
                vendingMachine.getAddressId(), vendingMachine.getContactNumber(), vendingMachine.getIsOutOfOrder(),
                vendingMachine.getIsEmpty(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
