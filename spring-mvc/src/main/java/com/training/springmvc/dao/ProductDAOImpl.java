package com.training.springmvc.dao;

import com.training.springmvc.model.Product;
import com.training.springmvc.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    JdbcTemplate jdbcTemplate;
    private final String SQL_GET_ALL_PRODUCTS = "select * from product";
@Autowired
public ProductDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query(SQL_GET_ALL_PRODUCTS, new ProductMapper());
    }
}
