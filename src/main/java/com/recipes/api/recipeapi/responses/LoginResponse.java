package com.recipes.api.recipeapi.responses;

public class LoginResponse {

    private String nameOfUser;
    private String userID;

    public LoginResponse(String name,String id){
        nameOfUser = name;
        userID = id;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
