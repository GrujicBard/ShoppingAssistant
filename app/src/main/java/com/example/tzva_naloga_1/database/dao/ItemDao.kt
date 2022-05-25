package com.example.tzva_naloga_1.database.dao

import androidx.room.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item ORDER BY itemId DESC")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: ItemEntity?)

    @Delete
    suspend fun deleteItem(item: ItemEntity?)

    @Query("DELETE FROM item")
    suspend fun deleteAllItems()

    @Update
    suspend fun updateItem(item: ItemEntity?)
}