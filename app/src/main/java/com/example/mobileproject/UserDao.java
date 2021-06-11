package com.example.mobileproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void makeNewUser (User user);

    @Query("SELECT COUNT(*) FROM users WHERE username = :username and password = :password")
    int checkCredentials (String username, String password);

    @Query("SELECT * FROM users WHERE username = :username")
    List<User> checkUsernameUnique (String username);
}
