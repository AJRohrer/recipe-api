package com.recipes.api.recipeapi.dataaccess;

import com.recipes.api.recipeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.awt.geom.GeneralPath;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (UserFirstName, UserLastName, UserPassword) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getUserFirstName());
            ps.setString(2, u.getUserLastName());
            ps.setString(3,u.getUserPassword());
            return ps;
        }, kh);
;
        return kh.getKey().intValue();
    }

    @Override
    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        Collection<Map<String,Object>> rows = jdbctemplate.queryForList("SELECT UserID, UserFirstName, UserLastName, UserPassword FROM Users");

        rows.stream().map((row) -> {
            User u = new User();
            u.setUserID(row.get("UserID").toString());
            u.setUserFirstName(row.get("UserFirstName").toString());
            u.setUserLastName(row.get("UserLastName").toString());
            u.setUserPassword(row.get("UserPassword").toString());
            return u;
            }).forEach((returnedUser) -> {
                userList.add(returnedUser);
            });
            return userList;
    }
}
