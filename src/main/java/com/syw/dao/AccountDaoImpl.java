package com.syw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
@Repository
public class AccountDaoImpl implements AccountDao{

    private JdbcTemplate jdbcTemplate;
    @Autowired//autowire方法用于注解：通过setDataSource来实例化JdbcTemplate
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    @Override
    public void transOut(Long id, BigDecimal money) {
        String sql="UPDATE account SET balance=balance-? WHERE id=?";
   jdbcTemplate.update(sql,money,id);
    }

    @Override
    public void tranIN(Long id, BigDecimal money) {
        String sql="UPDATE account SET balance=balance+? WHERE id=?";
        jdbcTemplate.update(sql,money,id);
    }
}
