package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.vo.Resource

interface Repo {

    fun getDrinkList(): Resource<List<Drink>>
}