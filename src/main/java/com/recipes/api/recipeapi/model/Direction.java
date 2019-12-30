package com.recipes.api.recipeapi.model;

public class Direction {


    private int _DirectionID;
    private int _DirectionNumber;
    private String _DirectionDescription;
    private int _RecipeID;

    public int get_DirectionID() {
        return _DirectionID;
    }

    public void set_DirectionID(int _DirectionID) {
        this._DirectionID = _DirectionID;
    }

    public int get_DirectionNumber() {
        return _DirectionNumber;
    }

    public void set_DirectionNumber(int _DirectionNumber) {
        this._DirectionNumber = _DirectionNumber;
    }

    public String get_DirectionDescription() {
        return _DirectionDescription;
    }

    public void set_DirectionDescription(String _DirectionDescription) {
        this._DirectionDescription = _DirectionDescription;
    }

    public int get_RecipeID() {
        return _RecipeID;
    }

    public void set_RecipeID(int _RecipeID) {
        this._RecipeID = _RecipeID;
    }
}
