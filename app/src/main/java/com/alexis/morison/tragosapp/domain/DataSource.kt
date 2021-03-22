package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.vo.Resource

interface DataSource {

    suspend fun getCocktailByName(cocktailName: String): Resource<List<Drink>>

    suspend fun insertCocktailIntoRoom(cocktail: DrinkEntity)

    suspend fun getFavouritesCocktails(): Resource<List<DrinkEntity>>

    suspend fun deleteCocktail(cocktail: DrinkEntity)
}