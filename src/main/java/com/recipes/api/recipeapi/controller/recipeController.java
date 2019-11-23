package com.recipes.api.recipeapi.controller;

import com.recipes.api.recipeapi.Recipe;
import com.recipes.api.recipeapi.RecipeCategory;
import com.recipes.api.recipeapi.dataaccess.UsersDataAccessImpl;
import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.utilities.KeyValuePair;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class recipeController {
    public static void main(String[] args){
        SpringApplication.run(recipeController.class, args);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){

        KeyValuePair kvp = new KeyValuePair("test", "test");
        kvp.setKey("testset");
        kvp.setValue("testval");

        return "Hello Andrew";
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        return null;
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

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/category", method = RequestMethod.GET)
    public ArrayList<Recipe> getCategories(){
        RecipeCategory rc = new RecipeCategory("Asian");
        ArrayList<KeyValuePair<String,String>> ingredientsAndQuantity = new ArrayList<>();

        ingredientsAndQuantity.add(new KeyValuePair<>("1 Cup", "White rice"));
        ingredientsAndQuantity.add(new KeyValuePair<>("2 Tbsp", "Soy Sauce"));
        ingredientsAndQuantity.add(new KeyValuePair<>("1/2 Cup", "Carrots"));
        ingredientsAndQuantity.add(new KeyValuePair<>("2", "Chicken Breast"));
        ingredientsAndQuantity.add(new KeyValuePair<>("3 Cups", "Water"));
        ArrayList<String> directions = new ArrayList<>();
        directions.add("Cook Chicken and rice in water.");
        directions.add("Add soy sauce.");
        directions.add("Steam carrots then add them to mixture.");
        directions.add("Serve after cooling for 5 minutes.");


        Recipe r = new Recipe("Fried Rice", ingredientsAndQuantity, directions, "https://my.testrecipe.com","This is the first recipe");
        rc.addRecipeToCategory(r);
        r = new Recipe("Eggrolls", ingredientsAndQuantity, directions, "https://my.testrecipe.com","This is the second recipe");
        rc.addRecipeToCategory(r);
        return rc.getCategoryRecipes();
    }

}
