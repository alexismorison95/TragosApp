package com.alexis.morison.tragosapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexis.morison.tragosapp.domain.RepoImplement

class ViewModelFactory(private val repo: RepoImplement) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return modelClass.getConstructor(RepoImplement::class.java).newInstance(repo)
    }
}