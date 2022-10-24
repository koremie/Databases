package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.TrademarkDao;
import com.lviv.iot.domain.Trademark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrademarkDaoImpl implements TrademarkDao {
    private static final String FIND_ALL = "SELECT * FROM trademark";
    private static final String FIND_BY_ID = "SELECT * FROM trademark WHERE name=?";
    private static final String CREATE = "INSERT INTO trademark (name) VALUES (?)";
    private static final String UPDATE = "UPDATE trademark SET name=? WHERE name=?";
    private static final String DELETE = "DELETE FROM trademark WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Trademark> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Trademark.class));
    }

    @Override
    public Optional<Trademark> findById(String name) {
        Optional<Trademark> trademark;
        try {
            trademark = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Trademark.class), name));
        } catch (EmptyResultDataAccessException e) {
            trademark = Optional.empty();
        }
        return trademark;
    }

    @Override
    public int create(Trademark trademark) {
        return jdbcTemplate.update(CREATE, trademark.getName());
    }

    @Override
    public int update(String name, Trademark trademark) {
        return jdbcTemplate.update(UPDATE, trademark.getName(), name);
    }

    @Override
    public int delete(String name) {
        return jdbcTemplate.update(DELETE, name);
    }
}
