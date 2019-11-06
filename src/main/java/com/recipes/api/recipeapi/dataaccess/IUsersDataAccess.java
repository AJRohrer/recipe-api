package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;

import java.util.ArrayList;

public interface IUsersDataAccess {

    public abstract int createUser(User u);

    public abstract ArrayList<User> getUsers();

}
