package com.example.tzva_naloga_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tzva_naloga_1.database.dao.ItemDao
import com.example.tzva_naloga_1.database.entities.ItemEntity

@Database(entities = arrayOf(ItemEntity::class), version = 2, exportSchema = false)
public abstract class ItemRoomDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao?;

    companion object {
        private var INSTANCE: ItemRoomDatabase? = null
        fun getDatabase(context: Context): ItemRoomDatabase? {
            if(INSTANCE == null ) {
                INSTANCE = Room.databaseBuilder<ItemRoomDatabase>(
                    context.applicationContext, ItemRoomDatabase::class.java, "item_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}