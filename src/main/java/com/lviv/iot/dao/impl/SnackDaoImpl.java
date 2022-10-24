package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.SnackDao;
import com.lviv.iot.domain.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SnackDaoImpl implements SnackDao {
    private static final String FIND_ALL = "SELECT * FROM snack";
    private static final String FIND_BY_ID = "SELECT * FROM snack WHERE id=?";
    private static final String CREATE = "INSERT INTO snack (name, net_weight, trademark_name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE snack SET name=?, net_weight=?, trademark_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM snack WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Snack> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Snack.class));
    }

    @Override
    public Optional<Snack> findById(Integer id) {
        Optional<Snack> snack;
        try {
            snack = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Snack.class), id));
        } catch (EmptyResultDataAccessException e) {
            snack = Optional.empty();
        }
        return snack;
    }

    @Override
    public int create(Snack snack) {
        return jdbcTemplate.update(CREATE, snack.getName(), snack.getNetWeight(), snack.getTrademarkName());
    }

    @Override
    public int update(Integer id, Snack snack) {
        return jdbcTemplate.update(UPDATE, snack.getName(), snack.getNetWeight(), snack.getTrademarkName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
