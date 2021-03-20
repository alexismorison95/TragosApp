package com.alexis.morison.tragosapp.data

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.vo.Resource
import com.alexis.morison.tragosapp.vo.RetrofitClient

class DataSource {

    suspend fun getCocktailByName(cocktailName: String): Resource<List<Drink>>  {

        return Resource.Success(RetrofitClient.webService.getCocktailByName(cocktailName).drinkList)
    }
}