package com.sidh.springboot.testqueryextraction.service;

import com.sidh.springboot.testqueryextraction.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class Jdbcservice {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> serve() {
        List<String> query = jdbcTemplate.query("select * from employee where first_name like '%an%'", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(2);
            }
        });
        return query;
    }
}
