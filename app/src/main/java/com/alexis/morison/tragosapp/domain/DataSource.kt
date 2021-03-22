package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.base.Resource

interface DataSource {

    suspend fun getCocktailByName(cocktailName: String): Resource<List<Cocktail>>

    suspend fun insertCocktailIntoRoom(cocktail: DrinkEntity)

    suspend fun getFavouritesCocktails(): Resource<List<DrinkEntity>>

    suspend fun deleteCocktail(cocktail: DrinkEntity)
}