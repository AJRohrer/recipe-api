package com.recipes.api.recipeapi.utilities;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RecipeJDBCTemplate {

    private RecipeJDBCTemplate() {}

    public static JdbcTemplate getDatabaseTemplate(){
        try {
            SimpleDriverDataSource ds = new SimpleDriverDataSource();
            ds.setDriver(new com.mysql.jdbc.Driver());
            ds.setUrl("jdbc:mysql://localhost:3306/recipedb");
            ds.setUsername("root");
            ds.setPassword("sqlrecipe");
            return new JdbcTemplate(ds);
        } catch (SQLException e) {
            return null;
        }
    }

    public static Connection getDatabaseConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "sqlrecipe");
        } catch (SQLException e){
            return null;
        }
    }
}
