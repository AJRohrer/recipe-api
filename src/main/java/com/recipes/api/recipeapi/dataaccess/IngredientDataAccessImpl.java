package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Ingredient;
import com.recipes.api.recipeapi.requests.IngredientRequest;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean insertRecipeIngredients(int recipeId, List<IngredientRequest> ingredients){
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            String sql = "INSERT INTO Ingredients (IngredientID, IngredientName, IngredientQuantity, RecipeID) " +
                    "VALUES (0,?,?,?)";

            jtp.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    IngredientRequest ir = ingredients.get(i);
                    preparedStatement.setString(1,ir.getIngredientName());
                    preparedStatement.setString(2,ir.getIngredientQuantity());
                    preparedStatement.setInt(3,recipeId);
                }

                @Override
                public int getBatchSize() {
                    return ingredients.size();
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
