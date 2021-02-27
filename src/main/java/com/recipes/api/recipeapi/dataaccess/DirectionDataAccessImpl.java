package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.Direction;
import com.recipes.api.recipeapi.requests.DirectionRequest;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean insertRecipeDirections(int recipeId, List<DirectionRequest> directions){
        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            String sql = "INSERT INTO Directions (DirectionID, DirectionNumber, DirectionDescription, RecipeID) " +
                    "VALUES (0,?,?,?)";

            jtp.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    DirectionRequest dr = directions.get(i);
                    preparedStatement.setInt(1, dr.getDirectionNumber());
                    preparedStatement.setString(2, dr.getDirectionDescription());
                    preparedStatement.setInt(3, recipeId);
                }

                @Override
                public int getBatchSize() {
                    return directions.size();
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
