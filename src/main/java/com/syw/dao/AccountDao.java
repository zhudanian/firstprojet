package com.syw.dao;

import java.math.BigDecimal;

public interface AccountDao {
    void transOut(Long id, BigDecimal money);
    void tranIN(Long id,BigDecimal money);
}
