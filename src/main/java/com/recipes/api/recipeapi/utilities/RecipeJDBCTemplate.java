package com.recipes.api.recipeapi.utilities;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

public class RecipeJDBCTemplate {

    private RecipeJDBCTemplate() {}

    public static JdbcTemplate getDatabaseTemplate(){
        try {
            SimpleDriverDataSource ds = new SimpleDriverDataSource();
            ds.setDriver(new com.mysql.jdbc.Driver());
            ds.setUrl("jdbc:mysql://localhost:3306/Grocery_Schema");
            ds.setUsername("root");
            ds.setPassword("docker");
            return new JdbcTemplate(ds);
        } catch (SQLException e) {
            return null;
        }
    }
}
