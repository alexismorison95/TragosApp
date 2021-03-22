package com.alexis.morison.tragosapp.ui.viewmodel

import androidx.lifecycle.*
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.vo.Resource
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

        liveData<Resource<List<Drink>>>(Dispatchers.IO) {

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
}