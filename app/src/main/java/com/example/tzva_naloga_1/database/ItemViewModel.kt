package com.example.tzva_naloga_1.database

import android.app.Application
import androidx.lifecycle.*
import com.example.tzva_naloga_1.database.entities.ItemEntity

class ItemViewModel(app: Application) : AndroidViewModel(app) {

    private var allItems : MutableLiveData<List<ItemEntity>> = MutableLiveData();

    init{
        allItems = MutableLiveData()
        getAllItems()
    }

    fun getAllItemsObservers(): MutableLiveData<List<ItemEntity>> {
        return allItems
    }

    fun getAllItems() {
        val itemDao = ItemRoomDatabase.getDatabase(getApplication())?.itemDao()
        val list = itemDao?.getAllItems()
        allItems.postValue(list!!)
    }

    fun insertItem(entity: ItemEntity){
        val itemDao = ItemRoomDatabase.getDatabase(getApplication())?.itemDao()
        itemDao?.insertItem(entity)
        getAllItems()
    }

    fun updateItem(entity: ItemEntity){
        val itemDao = ItemRoomDatabase.getDatabase(getApplication())?.itemDao()
        itemDao?.updateItem(entity)
        getAllItems()
    }

    fun deleteItem(entity: ItemEntity){
        val itemDao = ItemRoomDatabase.getDatabase(getApplication())?.itemDao()
        itemDao?.deleteItem(entity)
        getAllItems()
    }

    fun deleteAllItems(){
        val itemDao = ItemRoomDatabase.getDatabase(getApplication())?.itemDao()
        itemDao?.deleteAllItems()
    }
}