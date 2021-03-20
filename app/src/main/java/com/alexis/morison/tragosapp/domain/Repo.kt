package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.vo.Resource

interface Repo {

    suspend fun getDrinkList(cocktailName: String): Resource<List<Drink>>
}