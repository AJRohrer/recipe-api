package com.recipes.api.recipeapi;

import javafx.util.Pair;

import java.util.ArrayList;

public class Recipe {

    private String _recipeName;
    private ArrayList<Pair<String,String>> _quantityAndIngredient;
    private ArrayList<String> _directions;
    private String _url;
    private String _notes;

    public Recipe(String recipeName, ArrayList<Pair<String,String>> quantityAndIngredients,
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

    public ArrayList<Pair<String, String>> getQuantityAndIngredient(){
        return _quantityAndIngredient;
    }

    public String getNotes(){
        return _notes;
    }

    public ArrayList<String> getDirections(){
        return _directions;
    }

}
