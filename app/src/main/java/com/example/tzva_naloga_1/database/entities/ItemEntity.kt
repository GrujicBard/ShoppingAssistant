package com.example.tzva_naloga_1.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "item")
data class ItemEntity(

    @PrimaryKey(autoGenerate = true)
    val itemId: Long = 0L,
    val EAN: String,
    val name: String,
    val price: Double,
    val quantity: String,
    var stock: Int,
    val shop: String,
    val storage: String,
    val category: String,
    var IsFavoriteItem: Boolean,
    var IsOnShoppingList: Boolean,
    val description: String
)

enum class Storage{
    FREEZER,
    CUPBOARD,
    BATHROOM,
    CELLAR;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.uppercase() }
    }
}

enum class Shop{
    MERCATOR,
    SPAR,
    LIDL,
    TUŠ,
    HOFER;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.uppercase() }
    }
}

enum class ItemCategory{
    MILK_EGGS_AND_DAIRY_PRODUCTS,
    MEAT_AND_MEAT_PRODUCTS,
    BREAD_AND_PASTRIES,
    FROZEN_FOOD,
    SOFT_DRINKS,
    ALCOHOL,
    STEWS_SOUPS_RICE_AND_SAUCES,
    CLEANING_PRODUCTS;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.uppercase() }.replace("_"," ")
    }
}