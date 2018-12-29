package com.syw.dao;

import com.sun.tools.javac.jvm.ByteCodes;
import com.syw.pojo.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
//通过setDataSource将JdbcTemplate实例化
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    @Override
    public void save(Employee employee) {
        String sql="INSERT INTO employee1(name,age)VALUES(?,?)";
        jdbcTemplate.update(sql,employee.getName(),employee.getAge());
        System.out.println("保存数据。。");
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Employee> query() {
        String sql ="SELECT * FROM employee1";
        return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Employee>() {//object为查询条件
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {// int 为查询结果条数
                Employee e =new Employee();
                e.setId(resultSet.getInt("id"));
                e.setName(resultSet.getString("name"));
                e.setAge(resultSet.getInt("age"));
                return e;//返回值（查询结果）添加到list中
            }
        });
    }

    @Override
    public Employee queryById(Integer id) {
        String sql="SELECT * FROM employee1 WHERE id=?";
        List<Employee> list=jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee e =new Employee();
                e.setId(resultSet.getInt("id"));
                e.setName(resultSet.getString("name"));
                e.setAge(resultSet.getInt("age"));
                return e;
            }
        });
        return list.size()==1?list.get(0):null;//按id查询只能为一条记录（index=0）
    }
}
