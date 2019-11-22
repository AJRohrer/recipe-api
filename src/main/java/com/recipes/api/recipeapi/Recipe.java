package com.recipes.api.recipeapi;

import com.recipes.api.recipeapi.utilities.KeyValuePair;

import java.util.ArrayList;

public class Recipe {

    private String _recipeName;
    private ArrayList<KeyValuePair<String,String>> _quantityAndIngredient;
    private ArrayList<String> _directions;
    private String _url;
    private String _notes;

    public Recipe(String recipeName, ArrayList<KeyValuePair<String,String>> quantityAndIngredients,
                  ArrayList<String> directions, String url, String notes){
        _recipeName = recipeName;
        _quantityAndIngredient = quantityAndIngredients;
        _directions = directions;
        _url = url;
        _notes = notes;
    }

    public String getRecipeName(){
        return _recipeName;
    }

    public String getRecipeUrl(){
        return _url;
    }

    public ArrayList<KeyValuePair<String, String>> getQuantityAndIngredient(){
        return _quantityAndIngredient;
    }

    public String getNotes(){
        return _notes;
    }

    public ArrayList<String> getDirections(){
        return _directions;
    }

}
