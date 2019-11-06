package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;

public class UsersDataAccessImpl implements IUsersDataAccess {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public int createUser(User u) {
        return 0;
    }

    public ArrayList<User> getUsers(){
        return null;
    }

}
