package com.alexis.morison.tragosapp.domain

import androidx.room.*
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity

@Dao
interface DrinksDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getAllFavouriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(drink: DrinkEntity)

    @Delete
    suspend fun deleteDrink(drink: DrinkEntity)
}