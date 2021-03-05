package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;
import com.recipes.api.recipeapi.requests.CreateAccountRequest;
import com.recipes.api.recipeapi.requests.LoginRequest;
import com.recipes.api.recipeapi.utilities.RecipeJDBCTemplate;
import com.recipes.api.recipeapi.utilities.UserDataExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.util.List;

@Resource
public class UsersDataAccessImpl {

    @Autowired
    JdbcTemplate jdbctemplate;

    public UserDataExists createUser(CreateAccountRequest car) {
        UserDataExists ude = doesUserExist(car);
        if (ude == UserDataExists.USER_DOES_NOT_EXIST){
            try {
                ResultSet rs = insertUser(car);
                return rs != null ? UserDataExists.USER_CREATED_SUCCESSFULLY : UserDataExists.ERROR_CREATING_USER;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return ude;
    }

    private ResultSet insertUser(CreateAccountRequest car){
        String sql = "INSERT INTO Users VALUES (0,?,?,?,?,?)";
        try{
            PreparedStatement prepStmt = RecipeJDBCTemplate.getDatabaseConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, car.getFirstName());
            prepStmt.setString(2, car.getLastName());
            prepStmt.setString(3, car.getUserName());
            prepStmt.setString(4, car.getPassword());
            prepStmt.setString(5, car.getUserEmail());

            prepStmt.executeUpdate();
            return prepStmt.getGeneratedKeys();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private UserDataExists doesUserExist(CreateAccountRequest car){
        if (doesUserNameExist(car.getUserName())) return UserDataExists.USERNAME_EXISTS;
        if (doesUserEmailExist(car.getUserEmail())) return UserDataExists.EMAIL_EXISTS;
        return UserDataExists.USER_DOES_NOT_EXIST;
    }

    private boolean doesUserNameExist(String userName){
        try {
            String sqlUserName = "SELECT COUNT(*) FROM Users WHERE UserName = \"" + userName + "\"";

            Connection c = RecipeJDBCTemplate.getDatabaseConnection();
            Statement stmt;
            if (c != null){
                stmt = c.createStatement();
            } else {
                throw new Exception("Could not connect to database. (doesUserNameExist)");
            }
            ResultSet rs = stmt.executeQuery(sqlUserName);
            rs.next();
            return rs.getInt(1) > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
            return true; //return true because there was an error creating the user.
        }
    }

    private boolean doesUserEmailExist(String userEmail) {
        try {
            String sqlUserEmail = "SELECT COUNT(*) FROM Users WHERE UserEmail = \"" + userEmail + "\"";

            Connection c = RecipeJDBCTemplate.getDatabaseConnection();
            Statement stmt;
            if (c != null){
                stmt = c.createStatement();
            } else {
                throw new Exception("Could not connect to database. (doesUserEmailExist)");
            }
            ResultSet rs = stmt.executeQuery(sqlUserEmail);
            rs.next();
            return rs.getInt(1) > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
            return true; //return true because there was an error creating the user.
        }
    }

    public List<User> getUsers(){
       return null; //TODO
    }

    public User TrySignin(LoginRequest lr){

        try {
            JdbcTemplate jtp = RecipeJDBCTemplate.getDatabaseTemplate();

            //Get User Object
            RowMapper<User> rmUser = (ResultSet result, int rowNum) -> {
                User u = new User();
                u.setUserID(result.getString("UserID"));
                u.setUserFirstName(result.getString("UserFirstName"));
                u.setUserLastName(result.getString("UserLastName"));
                u.setUserName(result.getString("UserName"));
                u.setUserPassword(result.getString("UserPassword"));
                return u;

            };
            String sql = "SELECT * FROM Users WHERE UserName = ? AND UserPassword = ?";

            return jtp.queryForObject(sql, rmUser, lr.getUsername(),lr.getPassword());
        } catch (Exception e) {
            return null;
        }

    }
}
