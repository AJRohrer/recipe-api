package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class RecipeDataAccessImpl {

    public Recipe getRecipe(int recipeID){
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

            String sql = "SELECT * FROM Recipes WHERE RecipeID = ?";
            Recipe returnRecipe = jtp.queryForObject(sql,rmRecipe,recipeID);

            DirectionDataAccessImpl dda = new DirectionDataAccessImpl();
            IngredientDataAccessImpl ida = new IngredientDataAccessImpl();
            returnRecipe.set_Ingredients(ida.getRecipeIngredients(recipeID));
            returnRecipe.set_Directions(dda.getDirectionsForRecipe((recipeID)));
            return returnRecipe;

        } catch (Exception e) {
            return null;
        }
    }
}
