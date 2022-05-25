package com.example.tzva_naloga_1.database.entities

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
    val expirationDate: String,
    var IsFavoriteItem: Boolean,
    var IsOnShoppingList: Boolean,
    val description: String,
    val dateOfStorage: String? = LocalDateTime.now().toString(),
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
    HOFER;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.uppercase() }
    }
}