package com.example.tzva_naloga_1.database.dao

import androidx.room.*
import com.example.tzva_naloga_1.database.entities.ItemEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM item ORDER BY uid DESC")
    fun getAllItems(): List<ItemEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItem(item: ItemEntity?)

    @Delete
    fun deleteItem(item: ItemEntity?)

    @Query("DELETE FROM item")
    fun deleteAllItems()

    @Update
    fun updateUser(item: ItemEntity?)
}