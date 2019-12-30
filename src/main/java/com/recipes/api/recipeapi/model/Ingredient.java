package com.recipes.api.recipeapi.model;

public class Ingredient {


    private int _IngredientID;
    private String _IngredientName;
    private String _IngredientQuantity;
    private int _RecipeID;

    public int get_IngredientID() {
        return _IngredientID;
    }

    public void set_IngredientID(int _IngredientID) {
        this._IngredientID = _IngredientID;
    }


    public String get_IngredientName() {
        return _IngredientName;
    }

    public void set_IngredientName(String _IngredientName) {
        this._IngredientName = _IngredientName;
    }

    public String get_IngredientQuantity() {
        return _IngredientQuantity;
    }

    public void set_IngredientQuantity(String _IngredientQuantity) {
        this._IngredientQuantity = _IngredientQuantity;
    }

    public int get_RecipeID() {
        return _RecipeID;
    }

    public void set_RecipeID(int _RecipeID) {
        this._RecipeID = _RecipeID;
    }
}
