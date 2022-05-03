package com.example.tzva_naloga_1.database

import android.app.Application
import androidx.lifecycle.*
import com.example.tzva_naloga_1.database.entities.UserEntity

class UserViewModel(app: Application) : AndroidViewModel(app) {

    private var allUsers : MutableLiveData<List<UserEntity>> = MutableLiveData();

    init{
        allUsers = MutableLiveData()
        getAllUsers()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>> {
        return allUsers
    }

    fun getAllUsers() {
        val userDao = UserRoomDatabase.getDatabase(getApplication())?.userDao()
        val list = userDao?.getAllUsers()

        allUsers.postValue(list!!)
    }

    fun insertUser(entity: UserEntity){
        val userDao = UserRoomDatabase.getDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUsers()
    }

    fun updateUser(entity: UserEntity){
        val userDao = UserRoomDatabase.getDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUser(entity: UserEntity){
        val userDao = UserRoomDatabase.getDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }

    fun deleteAllUsers(){
        val userDao = UserRoomDatabase.getDatabase(getApplication())?.userDao()
        userDao?.deleteAllUsers()
    }
}