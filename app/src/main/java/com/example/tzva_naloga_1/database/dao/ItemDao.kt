package com.example.tzva_naloga_1.database.dao

import androidx.room.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item WHERE stock > 0 ORDER BY name DESC")
    fun getAllItems(): Flow<MutableList<ItemEntity>>

    @Query("SELECT * FROM item WHERE isFavoriteItem = 1 ORDER BY itemId DESC")
    fun getAllFavoriteItems(): Flow<MutableList<ItemEntity>>

    @Query("SELECT * FROM item WHERE isOnShoppingList = 1 ORDER BY itemId DESC")
    fun getAllShoppingItems(): Flow<MutableList<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: ItemEntity?)

    @Delete
    suspend fun deleteItem(item: ItemEntity?)

    @Query("DELETE FROM item")
    suspend fun deleteAllItems()

    @Update
    suspend fun updateItem(item: ItemEntity?)

    @Update
    suspend fun updateItems(items: List<ItemEntity>): Int

    @Query("DELETE FROM item WHERE selected = 1")
    suspend fun deleteAllSelected()

    @Query("DELETE FROM item WHERE stock = 0 AND isFavoriteItem = 0 AND isOnShoppingList = 0")
    suspend fun deleteGarbage()
}