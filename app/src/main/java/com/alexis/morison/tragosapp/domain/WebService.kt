package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getCocktailByName(@Query(value = "s") cocktailName: String): DrinkList
}