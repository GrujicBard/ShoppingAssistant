package com.example.tzva_naloga_1.database

import androidx.lifecycle.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import kotlinx.coroutines.launch

class FavoriteItemViewModel(private val repositoryFav: ItemRepository) : ViewModel(){
    val allFavoriteItems: LiveData<List<ItemEntity>> = repositoryFav.allFavoriteItems.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

    fun insertItem(item: ItemEntity) = viewModelScope.launch {
        repositoryFav.insertItem(item)
    }

    fun updateItem(item: ItemEntity) = viewModelScope.launch {
        repositoryFav.updateItem(item)
    }

    fun deleteAllItems() = viewModelScope.launch {
        repositoryFav.deleteAllItems()
    }

    fun deleteItem(item: ItemEntity) = viewModelScope.launch {
        repositoryFav.deleteAllItems(item)
    }

}

class FavoriteItemViewModelFactory(private val repositoryFav: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteItemViewModel(repositoryFav) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}