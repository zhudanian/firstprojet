package com.syw.service;

import java.math.BigDecimal;

public interface AccountService {
    void trans(Long outId, Long inId, BigDecimal money);//从指定账户转钱
}
