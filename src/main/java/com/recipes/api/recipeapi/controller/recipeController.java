package com.recipes.api.recipeapi.controller;

import com.recipes.api.recipeapi.dataaccess.CategoryDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.RecipeDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.UsersDataAccessImpl;
import com.recipes.api.recipeapi.model.Category;
import com.recipes.api.recipeapi.model.Recipe;
import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.requests.CreateAccountRequest;
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

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public String createUserAccount(@RequestBody CreateAccountRequest car){
        if (!car.getPassword().equals(car.getConfirmPassword())){
            return ("PASSWORD_MISMATCH");
        }
        UsersDataAccessImpl udai = new UsersDataAccessImpl();

        switch (udai.createUser(car)){
            case EMAIL_EXISTS:
            case USERNAME_EXISTS:
                return "USERNAME_OR_EMAIL_IN_USE";
            case USER_CREATED_SUCCESSFULLY:
                return "USER_CREATED_SUCCESSFULLY";
            default:
                return "ERROR";
        }
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
 }
