package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Ingredient;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class IngredientDataAccessImpl {

    public List<Ingredient> getRecipeIngredients(int recipeID){
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();
            RowMapper<Ingredient> rmIngredient = (ResultSet result, int rowNum) -> {
                Ingredient i = new Ingredient();
                i.set_IngredientID(result.getInt("IngredientID"));
                i.set_RecipeID(result.getInt("RecipeID"));
                i.set_IngredientName(result.getString("IngredientName"));
                i.set_IngredientQuantity(result.getString("IngredientQuantity"));
                return i;
            };

            String sql = "SELECT * FROM Ingredients WHERE RecipeID = ?";
            return jtp.query(sql, rmIngredient, recipeID);

        } catch (Exception e) {
            return null;
        }
    }

}
