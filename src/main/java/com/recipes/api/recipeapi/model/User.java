package com.recipes.api.recipeapi.model;

public class User {

    private String UserID;
    private String UserFirstName;
    private String UserLastName;
    private String UserPassword;
    private String UserName;

    public String getUserName() { return UserName; }

    public void setUserName(String userName) { UserName = userName; }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
