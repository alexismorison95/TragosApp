package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.DataSource
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.vo.Resource

class RepoImplement(private val dataSource: DataSource): Repo {

    override suspend fun getDrinkList(cocktailName: String): Resource<List<Drink>> {

        return dataSource.getCocktailByName(cocktailName)
    }

    override suspend fun getFavouritesDrinks(): Resource<List<DrinkEntity>> {

        return dataSource.getFavouritesCocktails()
    }

    override suspend fun insertDrink(drink: DrinkEntity) {

        dataSource.insertCocktailIntoRoom(drink)
    }
}
