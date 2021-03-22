package com.alexis.morison.tragosapp.data.local

import androidx.room.*
import com.alexis.morison.tragosapp.data.model.DrinkEntity

@Dao
interface DrinksDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getAllFavouriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(cocktail: DrinkEntity)

    @Delete
    suspend fun deleteDrink(cocktail: DrinkEntity)
}