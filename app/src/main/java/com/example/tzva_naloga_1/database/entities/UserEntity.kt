package com.example.tzva_naloga_1.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val name: String,
    val surname: String,
    val dateBirth: String,
    val heartRate: Int,
    val oxygen: Int,
    val bodyTemp: Int
)