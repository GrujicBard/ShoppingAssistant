package com.example.tzva_naloga_1.database

import androidx.annotation.WorkerThread
import com.example.tzva_naloga_1.database.dao.ItemDao
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao: ItemDao) {

    val allItems: Flow<MutableList<ItemEntity>> = itemDao.getAllItems()
    val allFavoriteItems: Flow<MutableList<ItemEntity>> = itemDao.getAllFavoriteItems()
    val allShoppingItems: Flow<MutableList<ItemEntity>> = itemDao.getAllShoppingItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertItem(item: ItemEntity) {
        itemDao.insertItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateItem(item: ItemEntity) {
        itemDao.updateItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateItems(items: List<ItemEntity>) {
        itemDao.updateItems(items)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAllItems() {
        itemDao.deleteAllItems()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteItem(item: ItemEntity) {
        itemDao.deleteItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAllItemsSelected() {
        itemDao.deleteAllSelected()
    }
}