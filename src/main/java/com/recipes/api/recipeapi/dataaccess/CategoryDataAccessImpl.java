package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Category;
import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class CategoryDataAccessImpl {

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

    public List<Recipe> getRecipesInCategory(int CategoryId){
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
            String sql = "SELECT * FROM Recipes WHERE CategoryID = ?";
            return jtp.query(sql, rmRecipe, CategoryId);

        } catch (Exception e) {
            return null;
        }

    }


}
