package com.example.tzva_naloga_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tzva_naloga_1.database.dao.ItemDao
import com.example.tzva_naloga_1.database.entities.ItemCategory
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.example.tzva_naloga_1.database.entities.Shop
import com.example.tzva_naloga_1.database.entities.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [ItemEntity::class], version = 14, exportSchema = false)
public abstract class ItemRoomDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao;

    private class ItemDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.itemDao())
                }
            }
        }

        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
            super.onDestructiveMigration(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.itemDao())
                }
            }
        }

        suspend fun populateDatabase(itemDao: ItemDao) {
            // Delete all content here.
            itemDao.deleteAllItems()

            // Add sample items.
            val item1 = ItemEntity(
                0,
                "3838800024967",
                "Trajno polnomastno mleko, 3,5 % m.m., Mercator",
                1.09,
                "1L",
                6,
                Shop.MERCATOR.toString(),
                Storage.FREEZER.toString(),
                ItemCategory.MILK_EGGS_AND_DAIRY_PRODUCTS.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "UHT polnomastno mleko z 3,5% mlečne maščobe.",
            )
            itemDao.insertItem(item1)
            val item2 = ItemEntity(
                0,
                "1644800024357",
                "Jajca L, hlevska reja, Mercator",
                1.99,
                "10 jajc",
                3,
                Shop.MERCATOR.toString(),
                Storage.FREEZER.toString(),
                ItemCategory.MILK_EGGS_AND_DAIRY_PRODUCTS.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "Jajca pred uporabo termično obdelati.",
            )
            itemDao.insertItem(item2)
            val item3 = ItemEntity(
                0,
                "865080043657",
                "Slane palčke, Hrusty",
                0.17,
                "220g",
                1,
                Shop.MERCATOR.toString(),
                Storage.CUPBOARD.toString(),
                ItemCategory.SALTY_SNACKS.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "PŠENIČNA moka, koruzni škrob, palmina maščoba, jodirana sol 2,5 % (sol, kalijev jodat), " +
                        "sladkor, emulgator: SOJIN lecitin; sredstva za vzhajanje: amonijevi karbonati; JEČMENOV slad, " +
                        "kvas, sredstvo za glaziranje: natrijev hidroksid.Lahko vsebuje sledi MLEKA, ARAŠIDOV in OREŠKOV." +
                        "Država porekla: Hrvaška.",
            )
            itemDao.insertItem(item3)
            val item4 = ItemEntity(
                0,
                "3831006616004",
                "Hrenovke piščančje IK, VP",
                3.49,
                "600g",
                2,
                Shop.TUŠ.toString(),
                Storage.FREEZER.toString(),
                ItemCategory.MEAT_PRODUCTS.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "strojno izkoščeno piščanje meso 66%, voda, piščančje kožice, krompirjev škrob, grahova moka," +
                        " vlakna citrusov, jedilna sol, začimbe, stabilizatorja: E 450, E 451; dekstroza, antioksidant: " +
                        "E 316; konzervansa: E 250, E 262.",
            )
            itemDao.insertItem(item4)
            val item5 = ItemEntity(
                0,
                "8596046616324",
                "WC čistilo Power Aktiv Gel Pine, Bref",
                1.78,
                "700ml",
                1,
                Shop.MERCATOR.toString(),
                Storage.BATHROOM.toString(),
                ItemCategory.CLEANING_PRODUCTS.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "Slike so simbolične, ponudnik si pridržuje pravico do tipkarskih napak.",
            )
            itemDao.insertItem(item5)
            val item6 = ItemEntity(
                0,
                "7485026612341",
                "Temno pivo Kozel, 3,8 %",
                1.23,
                "0,5L",
                12,
                Shop.SPAR.toString(),
                Storage.CELLAR.toString(),
                ItemCategory.ALCOHOL.toString(),
                IsFavoriteItem = false,
                IsOnShoppingList = false,
                "Voda, ječmenov slad, hmelj, hmeljni ekstrakt, sladkor..",
            )
            itemDao.insertItem(item6)

            // TODO: Add items!
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ItemRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                ).fallbackToDestructiveMigration().addCallback(ItemDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}