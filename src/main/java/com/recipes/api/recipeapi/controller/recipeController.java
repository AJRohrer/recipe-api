package com.recipes.api.recipeapi.controller;

import com.recipes.api.recipeapi.dataaccess.CategoryDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.RecipeDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.UsersDataAccessImpl;
import com.recipes.api.recipeapi.model.Category;
import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.requests.LoginRequest;
import com.recipes.api.recipeapi.requests.RecipeRequest;
import com.recipes.api.recipeapi.responses.LoginResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class recipeController {
    public static void main(String[] args){
        SpringApplication.run(recipeController.class, args);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public LoginResponse isUserValid(@RequestBody LoginRequest lr){
        UsersDataAccessImpl uda = new UsersDataAccessImpl();
        User user = uda.TrySignin(lr);
        return new LoginResponse(user.getUserFirstName() + " " + user.getUserLastName(), user.getUserID());
    }

    public LoginResponse createUserAccount(@RequestBody CreateAccountRequest car){
        LoginResponse lr = new LoginResponse()
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/hello")
    public String helloWorld(@RequestParam String teststring){
        return "This is the test string: " + teststring;
    }

    //************************************CATEGORY ENDPOINTS************************************
    @CrossOrigin(origins = "*")
    @GetMapping("/Categories")
    public List<Category> getUserCategories(@RequestParam int userId){
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.getUserCategories(userId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/recipes/{userid}")
    public List<Recipe> getUserRecipes(@PathVariable int userid){
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.getRecipesInCategory(userid);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/CreateCategory")
    public int createCategory(@RequestBody Category c) {
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.createNewCategory(c);
    }

    //************************************CATEGORY ENDPOINTS************************************

    //*************************************RECIPE ENDPOINTS*************************************
    @CrossOrigin(origins = "*")
    @GetMapping("/recipe/{recipeid}")
    public Recipe getRecipe(@PathVariable int recipeid) {
        RecipeDataAccessImpl rda = new RecipeDataAccessImpl();
        return rda.getRecipe(recipeid);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/createrecipe")
    public boolean createRecipe(@RequestBody RecipeRequest recipeRequest) {
        RecipeDataAccessImpl rda = new RecipeDataAccessImpl();
        return rda.createNewRecipe(recipeRequest);
    }
    //*************************************RECIPE ENDPOINTS*************************************

    @CrossOrigin(origins = "*")
    @PostMapping("/AddUser")
    public Boolean addUser(@RequestBody User u){

        UsersDataAccessImpl uda = new UsersDataAccessImpl();
        uda.createUser(u);

        return true;
    }

 }
