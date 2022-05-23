package com.example.tzva_naloga_1.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class ItemEntity (

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val EAN: String,
    val title: String,
    val dateOfStorage: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val isStoredCold: Boolean,
    val IsFavoriteItem: Boolean,
    val IsOnShoppingList: Boolean
)