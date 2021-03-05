-- Bootstrap Database as container for development

--docker run --name sqlrecipe -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=sqlrecipe <image name>
--Create schema recipedb;
--SchemaName: recipedb

--Java service connects under this user:
-- UN: recipeapi
-- PW: apirecipe

CREATE SCHEMA recipedb;
Use recipedb;

Create table if not exists Users (
	UserID int NOT NULL AUTO_INCREMENT,
    UserFirstName VARCHAR(100),
    UserLastName VARCHAR(100),
    UserName VARCHAR(100),
    UserPassword VARCHAR(100),
    UserEmail VARCHAR(150),
    PRIMARY KEY (UserID)
);

Create table if not exists Categories (
	CategoryID int NOT NULL AUTO_INCREMENT,
    CategoryName VARCHAR(100),
    UserID int,
    PRIMARY KEY (CategoryID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

Create table if not exists Recipes (
	RecipeID int NOT NULL AUTO_INCREMENT,
    CategoryID int NOT NULL,
    RecipeName VARCHAR(100),
    UserID int NOT NULL,
    RecipeURL VARCHAR(500),
    PRIMARY KEY (RecipeID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

Create table if not exists Ingredients (
    IngredientID int NOT NULL AUTO_INCREMENT,
	IngredientName VARCHAR(100),
    IngredientQuantity VARCHAR(30),
    RecipeID int NOT NULL,
    PRIMARY KEY (IngredientID),
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeID)
);

Create table if not exists Directions (
    DirectionID int NOT NULL AUTO_INCREMENT,
	DirectionNumber int NOT NULL,
    DirectionDescription VARCHAR(1000),
    RecipeID int NOT NULL,
    PRIMARY KEY (DirectionID),
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeID)
);

