package com.example.tzva_naloga_1.database.dao

import androidx.room.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item WHERE stock > 0 ORDER BY name DESC")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE IsFavoriteItem = 1 ORDER BY itemId DESC")
    fun getAllFavoriteItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE IsOnShoppingList = 1 ORDER BY itemId DESC")
    fun getAllShoppingItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: ItemEntity?)

    @Delete
    suspend fun deleteItem(item: ItemEntity?)

    @Query("DELETE FROM item")
    suspend fun deleteAllItems()

    @Update
    suspend fun updateItem(item: ItemEntity?)
}