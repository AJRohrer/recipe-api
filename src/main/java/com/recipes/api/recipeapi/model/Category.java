package com.recipes.api.recipeapi.model;

public class Category {

    private int _CategoryID;
    private String _CategoryName;
    private int _UserID;

    public int get_CategoryID() {
        return _CategoryID;
    }

    public void set_CategoryID(int _CategoryID) {
        this._CategoryID = _CategoryID;
    }

    public String get_CategoryName() {
        return _CategoryName;
    }

    public void set_CategoryName(String _CategoryName) {
        this._CategoryName = _CategoryName;
    }

    public int get_UserID() {
        return _UserID;
    }

    public void set_UserID(int _UserID) {
        this._UserID = _UserID;
    }
}
