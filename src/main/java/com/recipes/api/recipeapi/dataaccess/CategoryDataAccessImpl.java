package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDataAccessImpl {

    public List<Category> getUserCategories(int userID){
        try {
            SimpleDriverDataSource ds = new SimpleDriverDataSource();
            ds.setDriver(new com.mysql.jdbc.Driver());
            ds.setUrl("jdbc:mysql://localhost:3306/Grocery_Schema");
            ds.setUsername("root");
            ds.setPassword("docker");
            JdbcTemplate jtp = new JdbcTemplate(ds);

            RowMapper<Category> rmCategory = (ResultSet result, int rowNum) -> {
                Category c = new Category();

                c.set_CategoryID(result.getInt("CategoryID"));
                c.set_CategoryName(result.getString("CategoryName"));
                c.set_UserID(result.getInt("UserID"));
                return c;
            };
            String sql = "SELECT * FROM Categories WHERE UserID = ?";

            return jtp.query(sql, rmCategory, userID);

        } catch (SQLException e){
            return null;
        }
    }

}
