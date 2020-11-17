package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.requests.LoginRequest;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Resource
public class UsersDataAccessImpl {

    @Autowired
    JdbcTemplate jdbctemplate;

    public int createUser(User u) {
        return 0; //TODO
    }

    public List<User> getUsers(){
       return null; //TODO
    }

    public User TrySignin(LoginRequest lr){

        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            //Get User Object
            RowMapper<User> rmUser = (ResultSet result, int rowNum) -> {
                User u = new User();
                u.setUserID(result.getString("UserID"));
                u.setUserFirstName(result.getString("UserFirstName"));
                u.setUserLastName(result.getString("UserLastName"));
                u.setUserName(result.getString("UserName"));
                u.setUserPassword(result.getString("UserPassword"));
                return u;

            };
            String sql = "SELECT * FROM Users WHERE UserName = ? AND UserPassword = ?";

            return jtp.queryForObject(sql, rmUser, lr.getUsername(),lr.getPassword());
        } catch (Exception e) {
            return null;
        }

    }
}
