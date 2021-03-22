package com.alexis.morison.tragosapp.data

import com.alexis.morison.tragosapp.AppDatabase
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.vo.Resource
import com.alexis.morison.tragosapp.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getCocktailByName(cocktailName: String): Resource<List<Drink>>  {

        return Resource.Success(RetrofitClient.webService.getCocktailByName(cocktailName).drinkList)
    }

    suspend fun insertCocktailIntoRoom(cocktail: DrinkEntity) {

        appDatabase.drinkDao().insertFavourite(cocktail)
    }

    suspend fun getFavouritesCocktails(): Resource<List<DrinkEntity>> {

        return Resource.Success(appDatabase.drinkDao().getAllFavouriteDrinks())
    }
}