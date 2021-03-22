package com.alexis.morison.tragosapp.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexis.morison.tragosapp.data.model.DrinkEntity

@Dao
interface DrinksDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getAllFavouriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(drink: DrinkEntity)
}