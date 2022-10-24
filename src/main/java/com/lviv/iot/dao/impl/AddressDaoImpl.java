package com.lviv.iot.dao.impl;

import com.lviv.iot.dao.AddressDao;
import com.lviv.iot.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressDaoImpl implements AddressDao {
    private static final String FIND_ALL = "SELECT * FROM address";
    private static final String FIND_BY_ID = "SELECT * FROM address WHERE id=?";
    private static final String CREATE = "INSERT INTO address (city_id, street, house_number, appartment_number) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE address SET city_id=?, street=?, house_number=?, appartment_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM address WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Address> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Address.class));
    }

    @Override
    public Optional<Address> findById(Integer id) {
        Optional<Address> address;
        try {
            address = Optional.ofNullable(
                    jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Address.class), id));
        } catch (EmptyResultDataAccessException e) {
            address = Optional.empty();
        }
        return address;
    }

    @Override
    public int create(Address address) {
        return jdbcTemplate.update(CREATE, address.getId(), address.getCityId(), address.getStreet(),
                address.getHouseNumber(), address.getAppartmentNumber());
    }

    @Override
    public int update(Integer id, Address address) {
        return jdbcTemplate.update(UPDATE, address.getId(), address.getCityId(), address.getStreet(),
                address.getHouseNumber(), address.getAppartmentNumber(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
