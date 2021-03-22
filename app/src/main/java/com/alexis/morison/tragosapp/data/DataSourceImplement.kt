package com.alexis.morison.tragosapp.data

import com.alexis.morison.tragosapp.data.local.AppDatabase
import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.domain.DataSource
import com.alexis.morison.tragosapp.base.Resource
import com.alexis.morison.tragosapp.vo.RetrofitClient

class DataSourceImplement(private val appDatabase: AppDatabase) : DataSource {

    override suspend fun getCocktailByName(cocktailName: String): Resource<List<Cocktail>> {

        return Resource.Success(RetrofitClient.webService.getCocktailByName(cocktailName).cocktailList)
    }

    override suspend fun insertCocktailIntoRoom(cocktail: DrinkEntity) {

        appDatabase.drinkDao().insertFavourite(cocktail)
    }

    override suspend fun getFavouritesCocktails(): Resource<List<DrinkEntity>> {

        return Resource.Success(appDatabase.drinkDao().getAllFavouriteDrinks())
    }

    override suspend fun deleteCocktail(cocktail: DrinkEntity) {

        appDatabase.drinkDao().deleteDrink(cocktail)
    }
}