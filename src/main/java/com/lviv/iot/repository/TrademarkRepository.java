package com.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lviv.iot.domain.Trademark;

@Repository
public interface TrademarkRepository extends JpaRepository<Trademark, String> {
}