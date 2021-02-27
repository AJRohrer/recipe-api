package com.recipes.api.recipeapi.requests;

import java.util.List;

public class RecipeRequest {


    private String categoryId;
    private String recipeName;
    private String userId;
    private String recipeUrl;
    private List<IngredientRequest> ingredients;
    private List<DirectionRequest> directions;

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<IngredientRequest> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientRequest> ingredients) {
        this.ingredients = ingredients;
    }

    public List<DirectionRequest> getDirections() {
        return directions;
    }

    public void setDirections(List<DirectionRequest> directions) {
        this.directions = directions;
    }

}

