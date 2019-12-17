package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Resource
public class UsersDataAccessImpl implements IUsersDataAccess {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public int createUser(User u) {
        KeyHolder kh = new GeneratedKeyHolder();

        jdbctemplate.update((Connection conn) -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (UserFirstName, UserLastName, UserPassword) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getUserFirstName());
            ps.setString(2, u.getUserLastName());
            ps.setString(3, u.getUserName());
            ps.setString(4,u.getUserPassword());
            return ps;
        }, kh);
;
        return kh.getKey().intValue();
    }

    @Override
    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        Collection<Map<String,Object>> rows = jdbctemplate.queryForList("SELECT UserID, UserFirstName, UserLastName, UserName, UserPassword FROM Users");

        rows.stream().map((row) -> {
            User u = new User();
            u.setUserID(row.get("UserID").toString());
            u.setUserFirstName(row.get("UserFirstName").toString());
            u.setUserLastName(row.get("UserLastName").toString());
            u.setUserName(row.get("UserName").toString());
            u.setUserPassword(row.get("UserPassword").toString());
            return u;
            }).forEach((returnedUser) -> {
                userList.add(returnedUser);
            });
            return userList;
    }

    @Override
    public User getUser(String searchUserName){

        try {
            SimpleDriverDataSource ds = new SimpleDriverDataSource();
            ds.setDriver(new com.mysql.jdbc.Driver());
            ds.setUrl("jdbc:mysql://localhost:3306/Grocery_Schema");
            ds.setUsername("root");
            ds.setPassword("docker");
            JdbcTemplate jtp = new JdbcTemplate(ds);

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
            String sql = "SELECT * FROM Users WHERE UserName = 'AJRohrer'";

            return jtp.queryForObject(sql, rmUser);
        } catch (SQLException e) {
            return null;
        }

    }
}
