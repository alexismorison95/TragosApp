package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.vo.Resource

interface Repo {

    suspend fun getDrinkList(cocktailName: String): Resource<List<Drink>>

    suspend fun getFavouritesDrinks(): Resource<List<DrinkEntity>>

    suspend fun insertDrink(drink: DrinkEntity)
}