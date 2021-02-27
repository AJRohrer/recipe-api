package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.requests.RecipeRequest;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public boolean createNewRecipe(RecipeRequest rr){
        try {
            ResultSet rs = null;
            String sql = "INSERT INTO Recipes VALUES (0,?,?,?,?)";

            rs = insertRecipe(sql,rr);

            if (rs != null && rs.next()){
                IngredientDataAccessImpl idai = new IngredientDataAccessImpl();
                DirectionDataAccessImpl ddai = new DirectionDataAccessImpl();
                return idai.insertRecipeIngredients(rs.getInt(1), rr.getIngredients()) &&
                        ddai.insertRecipeDirections(rs.getInt(1), rr.getDirections());
            } else return false;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    private ResultSet insertRecipe(String sql, RecipeRequest rr) {
        try {
            PreparedStatement prepStatement = null;
            prepStatement = RecipeJDBCTemplate.getDatabaseConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, rr.getCategoryId());
            prepStatement.setString(2, rr.getRecipeName());
            prepStatement.setString(3, rr.getUserId());
            prepStatement.setString(4, rr.getRecipeUrl());

            prepStatement.executeUpdate();
            return prepStatement.getGeneratedKeys();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
