package com.recipes.api.recipeapi.controller;

import com.recipes.api.recipeapi.dataaccess.CategoryDataAccessImpl;
import com.recipes.api.recipeapi.dataaccess.UsersDataAccessImpl;
import com.recipes.api.recipeapi.model.Category;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/Categories")
    public List<Category> getUserCategories(@RequestParam int userId){
        CategoryDataAccessImpl cda = new CategoryDataAccessImpl();
        return cda.getUserCategories(userId);
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
