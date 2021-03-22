package com.alexis.morison.tragosapp.presentation

import androidx.lifecycle.*
import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.base.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repo: RepoImplement) : ViewModel() {

    private val cocktailData = MutableLiveData<String>()

    fun setCocktail(cocktailName: String) {

        cocktailData.value = cocktailName
    }

    init {
        setCocktail("margarita")
    }

    val fetchDrinkList = cocktailData.distinctUntilChanged().switchMap { nameString ->

        liveData<Resource<List<Cocktail>>>(Dispatchers.IO) {

            emit(Resource.Loading())

            try {
                emit(repo.getDrinkList(nameString))
            }
            catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun saveCocktail(cocktail: DrinkEntity) {

        viewModelScope.launch {

            repo.insertDrink(cocktail)
        }
    }

    fun getFavouritesCocktails() = liveData<Resource<List<DrinkEntity>>>(Dispatchers.IO) {

        emit(Resource.Loading())

        try {
            emit(repo.getFavouritesDrinks())
        }
        catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun deleteCocktail(cocktail: Cocktail) {

        viewModelScope.launch {

            val drinkEntity = DrinkEntity(
                cocktail.id,
                cocktail.name,
                cocktail.image,
                cocktail.description,
                cocktail.hasAlcohol,
                cocktail.ingredient1,
                cocktail.ingredient2,
                cocktail.ingredient3,
                cocktail.ingredient4,
                cocktail.ingredient5,
                cocktail.ingredient6,
            )

            repo.deleteDrink(drinkEntity)
        }
    }
}