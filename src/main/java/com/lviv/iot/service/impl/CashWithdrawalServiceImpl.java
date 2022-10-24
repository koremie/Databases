package com.lviv.iot.service.impl;

import com.lviv.iot.dao.CashWithdrawalDao;
import com.lviv.iot.domain.CashWithdrawal;
import com.lviv.iot.service.CashWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashWithdrawalServiceImpl implements CashWithdrawalService {
    @Autowired
    private CashWithdrawalDao cashWithdrawalDao;

    @Override
    public List<CashWithdrawal> findAll() {
        return cashWithdrawalDao.findAll();
    }

    @Override
    public Optional<CashWithdrawal> findById(Integer id) {
        return cashWithdrawalDao.findById(id);
    }

    @Override
    public int create(CashWithdrawal cashWithdrawal) {
        return cashWithdrawalDao.create(cashWithdrawal);
    }

    @Override
    public int update(Integer id, CashWithdrawal cashWithdrawal) {
        return cashWithdrawalDao.update(id, cashWithdrawal);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalDao.delete(id);
    }
}