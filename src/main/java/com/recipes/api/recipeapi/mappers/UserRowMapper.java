package com.recipes.api.recipeapi.mappers;

import com.recipes.api.recipeapi.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();

        u.setUserID(rs.getString("UserID"));
        u.setUserFirstName(rs.getString("UserFirstName"));
        u.setUserLastName(rs.getString("UserLastName"));
        u.setUserName(rs.getString("UserName"));
        u.setUserPassword(rs.getString("UserPassword"));
        return u;
    }
}
