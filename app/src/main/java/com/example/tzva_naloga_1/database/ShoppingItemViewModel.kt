package com.example.tzva_naloga_1.database

import androidx.lifecycle.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.launch

class ShoppingItemViewModel(private val repositoryShopping: ItemRepository) : ViewModel(){
    val allShoppingItems: LiveData<List<ItemEntity>> = repositoryShopping.allShoppingItems.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

    fun insertItem(item: ItemEntity) = viewModelScope.launch {
        repositoryShopping.insertItem(item)
    }

    fun updateItem(item: ItemEntity) = viewModelScope.launch {
        repositoryShopping.updateItem(item)
    }

    fun deleteAllItems() = viewModelScope.launch {
        repositoryShopping.deleteAllItems()
    }

    fun deleteItem(item: ItemEntity) = viewModelScope.launch {
        repositoryShopping.deleteAllItems(item)
    }

}

class ShoppingItemViewModelFactory(private val repositoryShopping: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoppingItemViewModel(repositoryShopping) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}