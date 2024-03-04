package com.training.springmvc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product prod = new Product();
        prod.setProdId(rs.getInt("prod_id"));
        prod.setProdName(rs.getString("prod_name"));
        prod.setProdDesc(rs.getString("prod_desc"));
        prod.setPrice(rs.getDouble("price"));
        return prod;
    }
}
