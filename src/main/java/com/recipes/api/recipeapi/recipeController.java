package com.recipes.api.recipeapi;

import javafx.util.Pair;
import org.springframework.boot.SpringApplication;
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
        return "Hello Andrew";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/category", method = RequestMethod.GET)
    public ArrayList<Recipe> getCategories(){
        RecipeCategory rc = new RecipeCategory("Asian");
        ArrayList<Pair<String,String>> ingredientsAndQuantity = new ArrayList<>();
        ingredientsAndQuantity.add(new Pair("1 Cup", "White rice"));
        ingredientsAndQuantity.add(new Pair("2 Tbsp", "Soy Sauce"));
        ingredientsAndQuantity.add(new Pair("1/2 Cup", "Carrots"));
        ingredientsAndQuantity.add(new Pair("2", "Chicken Breast"));
        ingredientsAndQuantity.add(new Pair("3 Cups", "Water"));
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
