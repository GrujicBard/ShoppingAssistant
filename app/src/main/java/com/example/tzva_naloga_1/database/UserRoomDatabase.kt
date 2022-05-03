package com.example.tzva_naloga_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tzva_naloga_1.database.dao.UserDao
import com.example.tzva_naloga_1.database.entities.UserEntity
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(UserEntity::class), version = 2, exportSchema = false)
public abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao?;

    companion object {

        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase? {

            if(INSTANCE == null ) {

                INSTANCE = Room.databaseBuilder<UserRoomDatabase>(
                    context.applicationContext, UserRoomDatabase::class.java, "user_database"
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