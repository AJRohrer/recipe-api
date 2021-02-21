package com.recipes.api.recipeapi.requests;

public class DirectionRequest {

    private int directionNumber;

    public int getDirectionNumber() {
        return directionNumber;
    }

    public void setDirectionNumber(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public String getDirectionDescription() {
        return directionDescription;
    }

    public void setDirectionDescription(String directionDescription) {
        this.directionDescription = directionDescription;
    }

    private String directionDescription;

}
