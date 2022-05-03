package com.example.tzva_naloga_1.database.dao

import androidx.room.*
import com.example.tzva_naloga_1.database.entities.UserEntity


@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY uid DESC")
    fun getAllUsers(): List<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    @Query("DELETE FROM user")
    fun deleteAllUsers()

    @Update
    fun updateUser(user: UserEntity?)
}