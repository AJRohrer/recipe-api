package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Direction;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class DirectionDataAccessImpl {

    public List<Direction> getDirectionsForRecipe(int RecipeID) {
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();
            RowMapper<Direction> rmDirection = (ResultSet result, int RowNum) -> {
                Direction d = new Direction();
                d.set_DirectionID(result.getInt("DirectionID"));
                d.set_DirectionNumber(result.getInt("DirectionNumber"));
                d.set_DirectionDescription(result.getString("DirectionDescription"));
                d.set_RecipeID(result.getInt("RecipeID"));
                return d;
            };

            String sql = "SELECT * FROM Directions WHERE RecipeID = ?";
            return jtp.query(sql, rmDirection, RecipeID);


        } catch (Exception e) {
            return null;
        }
    }
}
