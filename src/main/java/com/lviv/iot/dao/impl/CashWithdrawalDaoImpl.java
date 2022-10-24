package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.CashWithdrawalDao;
import com.lviv.iot.domain.CashWithdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CashWithdrawalDaoImpl implements CashWithdrawalDao {
    private static final String FIND_ALL = "SELECT * FROM cash_withdrawal";
    private static final String FIND_BY_ID = "SELECT * FROM cash_withdrawal WHERE id=?";
    private static final String CREATE = "INSERT INTO "
            + "cash_withdrawal (vending_machine_id, service_staff_id, amount, date) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE cash_withdrawal SET "
            + "vending_machine_id=?, service_staff_id=?, amount=?, date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cash_withdrawal WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CashWithdrawal> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CashWithdrawal.class));
    }

    @Override
    public Optional<CashWithdrawal> findById(Integer id) {
        Optional<CashWithdrawal> cashWithdrawal;
        try {
            cashWithdrawal = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(CashWithdrawal.class), id));
        } catch (EmptyResultDataAccessException e) {
            cashWithdrawal = Optional.empty();
        }
        return cashWithdrawal;
    }

    @Override
    public int create(CashWithdrawal cashWithdrawal) {
        return jdbcTemplate.update(CREATE, cashWithdrawal.getVendingMachineId(), cashWithdrawal.getServiceStaffId(),
                cashWithdrawal.getAmount(), cashWithdrawal.getDate());
    }

    @Override
    public int update(Integer id, CashWithdrawal cashWithdrawal) {
        return jdbcTemplate.update(UPDATE, cashWithdrawal.getVendingMachineId(), cashWithdrawal.getServiceStaffId(),
                cashWithdrawal.getAmount(), cashWithdrawal.getDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
