Use Grocery_Schema;
INSERT INTO Users VALUES(0, 'Andrew', 'Rohrer', 'AJRohrer', 'docker');
INSERT INTO Users VALUES(0, 'Katherine', 'Rohrer', 'KARohrer', 'diddlydoos');
INSERT INTO Users VALUES(0, 'Michael', 'Rohrer', 'MRRohrer', 'apple');
INSERT INTO Users VALUES(0, 'Jill', 'Rohrer', 'JTRohrer', 'bookkeeper');
INSERT INTO Users VALUES(0, 'Rob', 'Rohrer', 'RVRohrer', 'lakehouse');
SELECT * FROM Users;

INSERT INTO Categories VALUES(0, 'Asian', '1');
INSERT INTO Categories VALUES(0, 'Comfort', '1');
--
INSERT INTO Categories VALUES(0, 'Italian', '2');
INSERT INTO Categories VALUES(0, 'American', '2');
--
INSERT INTO Categories VALUES(0, 'Middle Eastern', '3');
INSERT INTO Categories VALUES(0, 'Desserts', '3');
--
INSERT INTO Categories VALUES(0, 'Chinese', '4');
INSERT INTO Categories VALUES(0, 'Indian', '4');
--
INSERT INTO Categories VALUES(0, 'Thai', '5');
INSERT INTO Categories VALUES(0, 'Appetizers', '5');
--
Select * FROM Categories;

INSERT INTO Recipes VALUES(0, 1, 'General Tsos Chicken', 1, 'https://dinnerthendessert.com/general-tsos-chicken/');
INSERT INTO Recipes VALUES(0, 1, 'Beef and Broccoli', 1, 'https://www.justataste.com/easy-beef-and-broccoli-recipe/');
INSERT INTO Recipes VALUES(0, 2, 'Mac and Cheese', 1, 'https://www.momontimeout.com/best-homemade-baked-mac-and-cheese-recipe/');
INSERT INTO Recipes VALUES(0, 2, 'Chicken Noodle Soup', 1, 'https://www.tasteofhome.com/recipes/the-ultimate-chicken-noodle-soup/');
--
INSERT INTO Recipes VALUES(0, 3, 'Pasta', 2, '');
INSERT INTO Recipes VALUES(0, 3, 'Pizza', 2, '');
INSERT INTO Recipes VALUES(0, 4, 'Hamburgers', 2, '');
INSERT INTO Recipes VALUES(0, 4, 'Pulled Pork', 2, '');
--
INSERT INTO Recipes VALUES(0, 5, 'Hummus', 3, '');
INSERT INTO Recipes VALUES(0, 5, 'Chicken Schwarma', 3, '');
INSERT INTO Recipes VALUES(0, 6, 'Cheesecake', 3, '');
INSERT INTO Recipes VALUES(0, 6, 'Chocolate Chip Cookies', 3, '');
--
INSERT INTO Recipes VALUES(0, 7, 'Chicken Fried Rice', 4, '');
INSERT INTO Recipes VALUES(0, 7, 'Orange Chicken', 4, '');
INSERT INTO Recipes VALUES(0, 8, 'Red Curry Rice', 4, '');
INSERT INTO Recipes VALUES(0, 8, 'Butter Chicken', 4, '');
--
INSERT INTO Recipes VALUES(0, 9, 'Basil Fried Rice', 5, '');
INSERT INTO Recipes VALUES(0, 9, 'Peanut Chicken', 5, '');
INSERT INTO Recipes VALUES(0, 10, 'BBQ Wings', 5, '');
INSERT INTO Recipes VALUES(0, 10, 'Guacamole', 5, '');
--
SELECT * FROM Recipes;

INSERT INTO Ingredients VALUES (0,'Chicken', '1 lb', 1);
INSERT INTO Ingredients VALUES (0,'Fish Sauce', '1/4 Cup', 1);
INSERT INTO Ingredients VALUES (0,'Honey', '1/2 Cup', 1);
INSERT INTO Ingredients VALUES (0,'Rice', '1 Cup Uncooked', 1);
INSERT INTO Ingredients VALUES (0,'Corn Starch', '2 tsp', 1);
--
INSERT INTO Ingredients VALUES (0,'Beef', '1 lb', 2);
INSERT INTO Ingredients VALUES (0,'Broccoli', '2 Cup', 2);
INSERT INTO Ingredients VALUES (0,'Soy Sauce', '1/4 Cup', 2);
INSERT INTO Ingredients VALUES (0,'Rice', '1 Cup Uncooked', 2);
INSERT INTO Ingredients VALUES (0,'Eggs', '2 large', 2);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 3);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 3);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 3);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 3);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 3);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 4);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 4);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 4);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 4);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 4);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 5);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 5);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 5);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 5);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 5);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 6);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 6);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 6);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 6);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 6);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 7);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 7);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 7);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 7);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 7);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 8);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 8);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 8);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 8);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 8);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 9);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 9);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 9);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 9);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 9);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 10);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 10);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 10);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 10);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 10);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 11);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 11);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 11);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 11);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 11);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 12);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 12);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 12);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 12);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 12);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 13);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 13);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 13);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 13);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 13);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 14);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 14);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 14);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 14);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 14);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 15);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 15);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 15);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 15);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 15);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 16);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 16);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 16);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 16);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 16);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 17);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 17);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 17);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 17);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 17);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 18);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 18);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 18);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 18);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 18);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 19);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 19);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 19);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 19);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 19);
--
INSERT INTO Ingredients VALUES (0,'Test1', '1 lb', 20);
INSERT INTO Ingredients VALUES (0,'Test2', '2 Cup', 20);
INSERT INTO Ingredients VALUES (0,'Test3', '1/4 Cup', 20);
INSERT INTO Ingredients VALUES (0,'Test4', '1 Cup Uncooked', 20);
INSERT INTO Ingredients VALUES (0,'Test5', '2 large', 20);
--
SELECT * FROM Ingredients;

INSERT INTO Directions VALUES (0,1, 'Cook Chicken and fish sauce in pan until chicken is 165F', 1);
INSERT INTO Directions VALUES (0,3, 'Add honey and simmer', 1);
INSERT INTO Directions VALUES (0,4, 'In the meantime, cook rice separately', 1);
INSERT INTO Directions VALUES (0,5, 'Add corn starch and mix then serve', 1);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 2);
INSERT INTO Directions VALUES (0,3, 'Test2', 2);
INSERT INTO Directions VALUES (0,4, 'Test3', 2);
INSERT INTO Directions VALUES (0,5, 'Test4', 2);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 3);
INSERT INTO Directions VALUES (0,3, 'Test2', 3);
INSERT INTO Directions VALUES (0,4, 'Test3', 3);
INSERT INTO Directions VALUES (0,5, 'Test4', 3);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 4);
INSERT INTO Directions VALUES (0,3, 'Test2', 4);
INSERT INTO Directions VALUES (0,4, 'Test3', 4);
INSERT INTO Directions VALUES (0,5, 'Test4', 4);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 5);
INSERT INTO Directions VALUES (0,3, 'Test2', 5);
INSERT INTO Directions VALUES (0,4, 'Test3', 5);
INSERT INTO Directions VALUES (0,5, 'Test4', 5);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 6);
INSERT INTO Directions VALUES (0,3, 'Test2', 6);
INSERT INTO Directions VALUES (0,4, 'Test3', 6);
INSERT INTO Directions VALUES (0,5, 'Test4', 6);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 7);
INSERT INTO Directions VALUES (0,3, 'Test2', 7);
INSERT INTO Directions VALUES (0,4, 'Test3', 7);
INSERT INTO Directions VALUES (0,5, 'Test4', 7);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 8);
INSERT INTO Directions VALUES (0,3, 'Test2', 8);
INSERT INTO Directions VALUES (0,4, 'Test3', 8);
INSERT INTO Directions VALUES (0,5, 'Test4', 8);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 9);
INSERT INTO Directions VALUES (0,3, 'Test2', 9);
INSERT INTO Directions VALUES (0,4, 'Test3', 9);
INSERT INTO Directions VALUES (0,5, 'Test4', 9);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 10);
INSERT INTO Directions VALUES (0,3, 'Test2', 10);
INSERT INTO Directions VALUES (0,4, 'Test3', 10);
INSERT INTO Directions VALUES (0,5, 'Test4', 10);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 11);
INSERT INTO Directions VALUES (0,3, 'Test2', 11);
INSERT INTO Directions VALUES (0,4, 'Test3', 11);
INSERT INTO Directions VALUES (0,5, 'Test4', 11);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 12);
INSERT INTO Directions VALUES (0,3, 'Test2', 12);
INSERT INTO Directions VALUES (0,4, 'Test3', 12);
INSERT INTO Directions VALUES (0,5, 'Test4', 12);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 13);
INSERT INTO Directions VALUES (0,3, 'Test2', 13);
INSERT INTO Directions VALUES (0,4, 'Test3', 13);
INSERT INTO Directions VALUES (0,5, 'Test4', 13);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 14);
INSERT INTO Directions VALUES (0,3, 'Test2', 14);
INSERT INTO Directions VALUES (0,4, 'Test3', 14);
INSERT INTO Directions VALUES (0,5, 'Test4', 14);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 15);
INSERT INTO Directions VALUES (0,3, 'Test2', 15);
INSERT INTO Directions VALUES (0,4, 'Test3', 15);
INSERT INTO Directions VALUES (0,5, 'Test4', 15);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 16);
INSERT INTO Directions VALUES (0,3, 'Test2', 16);
INSERT INTO Directions VALUES (0,4, 'Test3', 16);
INSERT INTO Directions VALUES (0,5, 'Test4', 16);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 17);
INSERT INTO Directions VALUES (0,3, 'Test2', 17);
INSERT INTO Directions VALUES (0,4, 'Test3', 17);
INSERT INTO Directions VALUES (0,5, 'Test4', 17);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 18);
INSERT INTO Directions VALUES (0,3, 'Test2', 18);
INSERT INTO Directions VALUES (0,4, 'Test3', 18);
INSERT INTO Directions VALUES (0,5, 'Test4', 18);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 19);
INSERT INTO Directions VALUES (0,3, 'Test2', 19);
INSERT INTO Directions VALUES (0,4, 'Test3', 19);
INSERT INTO Directions VALUES (0,5, 'Test4', 19);
--
INSERT INTO Directions VALUES (0,1, 'Test1', 20);
INSERT INTO Directions VALUES (0,3, 'Test2', 20);
INSERT INTO Directions VALUES (0,4, 'Test3', 20);
INSERT INTO Directions VALUES (0,5, 'Test4', 20);
--
SELECT * FROM Directions;