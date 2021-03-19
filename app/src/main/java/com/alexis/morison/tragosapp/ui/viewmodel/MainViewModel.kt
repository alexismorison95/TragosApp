package com.alexis.morison.tragosapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: RepoImplement) : ViewModel() {

    val fetchDrinkList = liveData<Resource<List<Drink>>>(Dispatchers.IO) {

        emit(Resource.Loading())

        try {
            emit(repo.getDrinkList())
        }
        catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}