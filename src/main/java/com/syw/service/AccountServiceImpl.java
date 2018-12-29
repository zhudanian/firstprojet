package com.syw.service;

import com.syw.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void trans(Long outId, Long inId, BigDecimal money) {
       accountDao.transOut(outId,money);
       //int i=1/0;
       accountDao.tranIN(inId,money);
        System.out.println("success");

    }
}
