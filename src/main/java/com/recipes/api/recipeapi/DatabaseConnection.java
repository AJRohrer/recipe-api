package com.recipes.api.recipeapi;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoCredential;

import java.util.Arrays;
public class DatabaseConnection {
    MongoClient _client;
    public DatabaseConnection(){
        _client = MongoClients.create("mongodb://localhost:27017");
    }

    public MongoClient getDbConnection(){
        MongoCredential credential = MongoCredential.createCredential("mongoaccount", "testdb","password".toCharArray());
        System.out.println("Connected to db");

        MongoDatabase db = _client.getDatabase("testdb");
        System.out.println("Credentials ::" + credential);
        return null;
    }
}
