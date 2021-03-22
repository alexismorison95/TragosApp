package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.base.Resource

class RepoImplement(private val dataSource: DataSource): Repo {

    override suspend fun getDrinkList(cocktailName: String): Resource<List<Cocktail>> {

        return dataSource.getCocktailByName(cocktailName)
    }

    override suspend fun getFavouritesDrinks(): Resource<List<DrinkEntity>> {

        return dataSource.getFavouritesCocktails()
    }

    override suspend fun insertDrink(drink: DrinkEntity) {

        dataSource.insertCocktailIntoRoom(drink)
    }

    override suspend fun deleteDrink(drink: DrinkEntity) {

        dataSource.deleteCocktail(drink)
    }
}
