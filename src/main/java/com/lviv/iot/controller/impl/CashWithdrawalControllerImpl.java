package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.CashWithdrawalController;
import com.lviv.iot.domain.CashWithdrawal;
import com.lviv.iot.service.CashWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashWithdrawalControllerImpl implements CashWithdrawalController {
    @Autowired
    private CashWithdrawalService cashWithdrawalService;

    @Override
    public List<CashWithdrawal> findAll() {
        return cashWithdrawalService.findAll();
    }

    @Override
    public Optional<CashWithdrawal> findById(Integer id) {
        return cashWithdrawalService.findById(id);
    }

    @Override
    public int create(CashWithdrawal cashWithdrawal) {
        return cashWithdrawalService.create(cashWithdrawal);
    }

    @Override
    public int update(Integer id, CashWithdrawal cashWithdrawal) {
        return cashWithdrawalService.update(id, cashWithdrawal);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalService.delete(id);
    }
}