package com.hypech.case9login_room.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void add(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("SELECT * FROM USER ORDER BY ID DESC")
    List<User> getAllUsers();

    @Query("SELECT * FROM USER WHERE name = :pName and password = :pPwd")
    User getOneUser(String pName, String pPwd);
}