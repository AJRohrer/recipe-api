package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Category;
import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDataAccessImpl {

    /*public List<Category> getUserCategories(int userID){
        try{
            Connection conn = RecipeJDBCTemplate.getDatabaseConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Categories WHERE UserID = " + userID);
            List<Category> userCategoryList = new ArrayList<>();
            while(rs.next()){
                Category c = new Category();
                c.set_CategoryID(rs.getInt("CategoryID"));
                c.set_CategoryName(rs.getString("CategoryName"));
                c.set_UserID(rs.getInt("UserID"));
                userCategoryList.add(c);
            }
            return userCategoryList;
        } catch (Exception e) {
            return null;
        }
    }*/

    public List<Category> getUserCategories(int userID){
        try {

            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            RowMapper<Category> rmCategory = (ResultSet result, int rowNum) -> {
                Category c = new Category();

                c.set_CategoryID(result.getInt("CategoryID"));
                c.set_CategoryName(result.getString("CategoryName"));
                c.set_UserID(result.getInt("UserID"));
                return c;
            };
            String sql = "SELECT * FROM Categories WHERE UserID = ?";

            return jtp.query(sql, rmCategory, userID);

        } catch (Exception e){
            return null;
        }
    }

    public List<Recipe> getRecipesInCategory(int userid){
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            RowMapper<Recipe> rmRecipe = (ResultSet result, int rowNum) -> {
                Recipe r = new Recipe();

                r.set_RecipeID(result.getInt("RecipeID"));
                r.set_CategoryID(result.getInt("CategoryID"));
                r.set_RecipeName(result.getString("RecipeName"));
                r.set_UserID(result.getInt("UserID"));
                r.set_RecipeUrl(result.getString("RecipeURL"));
                return r;
            };
            String sql = "SELECT * FROM Recipes WHERE UserID = ?";
            return jtp.query(sql, rmRecipe, userid);

        } catch (Exception e) {
            return null;
        }

    }

    public int createNewCategory(Category c){
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            String sql = "INSERT INTO Categories VALUES (0,?,?)";

            return jtp.update(sql, new Object[] {c.get_CategoryName(),c.get_UserID()});

        } catch (Exception e) {
            return 0;
        }
    }


}
