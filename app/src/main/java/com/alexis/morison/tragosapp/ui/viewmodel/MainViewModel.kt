package com.alexis.morison.tragosapp.ui.viewmodel

import androidx.lifecycle.*
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers

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
}