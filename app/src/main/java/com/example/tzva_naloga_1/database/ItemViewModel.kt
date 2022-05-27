package com.example.tzva_naloga_1.database

import androidx.lifecycle.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel(){

    val allItems: LiveData<MutableList<ItemEntity>> = repository.allItems.asLiveData()
    val allFavoriteItems: LiveData<MutableList<ItemEntity>> = repository.allFavoriteItems.asLiveData()
    val allShoppingItems: LiveData<MutableList<ItemEntity>> = repository.allShoppingItems.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

    fun insertItem(item: ItemEntity) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun updateItem(item: ItemEntity) = viewModelScope.launch {
        repository.updateItem(item)
    }

    fun updateItems(items: List<ItemEntity>) = viewModelScope.launch {
        repository.updateItems(items)
    }

    fun deleteAllItems() = viewModelScope.launch {
        repository.deleteAllItems()
    }

    fun deleteItem(item: ItemEntity) = viewModelScope.launch {
        repository.deleteItem(item)
    }

    fun deleteAllItemsSelected() = viewModelScope.launch {
        repository.deleteAllItemsSelected()
    }

}

class ItemViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}