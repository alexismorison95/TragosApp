package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.base.Resource

interface Repo {

    suspend fun getDrinkList(cocktailName: String): Resource<List<Cocktail>>

    suspend fun getFavouritesDrinks(): Resource<List<DrinkEntity>>

    suspend fun insertDrink(drink: DrinkEntity)

    suspend fun deleteDrink(drink: DrinkEntity)
}