package com.recipes.api.recipeapi.controller;

import com.recipes.api.recipeapi.dataaccess.CategoryDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.RecipeDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.UsersDataAccessImpl;
import com.recipes.api.recipeapi.model.Category;
import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.utilities.KeyValuePair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class recipeController {
    public static void main(String[] args){
        SpringApplication.run(recipeController.class, args);
    }


    //************************************CATEGORY ENDPOINTS************************************
    @CrossOrigin(origins = "*")
    @GetMapping("/Categories")
    public List<Category> getUserCategories(@RequestParam int userId){
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.getUserCategories(userId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/Recipes")
    public List<Recipe> getCategoryRecipes(int CategoryId){
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.getRecipesInCategory(CategoryId);
    }
    //************************************CATEGORY ENDPOINTS************************************

    //*************************************RECIPE ENDPOINTS*************************************
    public Recipe getRecipe(int RecipeID) {
        RecipeDataAccessImpl rda = new RecipeDataAccessImpl();
        return rda.getRecipe(RecipeID);
    }
    //*************************************RECIPE ENDPOINTS*************************************

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){

        KeyValuePair kvp = new KeyValuePair("test", "test");
        kvp.setKey("testset");
        kvp.setValue("testval");

        return "Hello Andrew";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/User")
    public User getUser(@RequestParam String userName){
        UsersDataAccessImpl uda = new UsersDataAccessImpl();
        return uda.getUser(userName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/AddUser")
    public Boolean addUser(@RequestBody User u){

        UsersDataAccessImpl uda = new UsersDataAccessImpl();
        uda.createUser(u);

        return true;
    }

}
