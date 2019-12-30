package com.recipes.api.recipeapi.model;

import java.util.List;

public class Recipe {
    private int _RecipeID;
    private int _CategoryID;
    private String _RecipeName;
    private int _UserID;
    private String _RecipeUrl;
    private List<Ingredient> _Ingredients;
    private List<Direction> _Directions;

    public List<Ingredient> get_Ingredients() {
        return _Ingredients;
    }

    public void set_Ingredients(List<Ingredient> _Ingredients) {
        this._Ingredients = _Ingredients;
    }

    public List<Direction> get_Directions() {
        return _Directions;
    }

    public void set_Directions(List<Direction> _Directions) {
        this._Directions = _Directions;
    }

    public int get_RecipeID() {
        return _RecipeID;
    }

    public void set_RecipeID(int _RecipeID) {
        this._RecipeID = _RecipeID;
    }

    public int get_CategoryID() {
        return _CategoryID;
    }

    public void set_CategoryID(int _CategoryID) {
        this._CategoryID = _CategoryID;
    }

    public String get_RecipeName() {
        return _RecipeName;
    }

    public void set_RecipeName(String _RecipeName) {
        this._RecipeName = _RecipeName;
    }

    public int get_UserID() {
        return _UserID;
    }

    public void set_UserID(int _UserID) {
        this._UserID = _UserID;
    }

    public String get_RecipeUrl() {
        return _RecipeUrl;
    }

    public void set_RecipeUrl(String _RecipeUrl) {
        this._RecipeUrl = _RecipeUrl;
    }
}
