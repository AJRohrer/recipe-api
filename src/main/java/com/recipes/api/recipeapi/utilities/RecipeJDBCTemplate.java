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
            ds.setUrl("jdbc:mysql://recipedb.czkixtffedni.us-east-2.rds.amazonaws.com:3306/Grocery_Schema");
            ds.setUsername("admin");
            ds.setPassword("docker02245!");
            return new JdbcTemplate(ds);
        } catch (SQLException e) {
            return null;
        }
    }
}
