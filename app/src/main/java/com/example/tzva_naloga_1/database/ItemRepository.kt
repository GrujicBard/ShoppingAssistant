package com.example.tzva_naloga_1.database

import androidx.annotation.WorkerThread
import com.example.tzva_naloga_1.database.dao.ItemDao
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao: ItemDao) {

    val allItems: Flow<List<ItemEntity>> = itemDao.getAllItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: ItemEntity) {
        itemDao.insertItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        itemDao.deleteAllItems()
    }
}