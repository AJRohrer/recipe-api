package com.recipes.api.recipeapi;

import java.util.ArrayList;

public class RecipeCategory {
    private String _categoryName;
    private ArrayList<Recipe> _recipesInCategory = new ArrayList<>();

    public RecipeCategory(String categoryName){
        _categoryName = categoryName;
    }

    public void addRecipeToCategory(Recipe newRecipe){
        _recipesInCategory.add(newRecipe);
    }

    public ArrayList<Recipe> getCategoryRecipes(){
        return _recipesInCategory;
    }

    public int getNumberOfRecipesInCategory(){
        return _recipesInCategory.size();
    }
}
