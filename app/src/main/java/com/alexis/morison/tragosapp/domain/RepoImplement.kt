package com.alexis.morison.tragosapp.domain

import com.alexis.morison.tragosapp.data.DataSource
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.vo.Resource

class RepoImplement(private val dataSource: DataSource): Repo {

    override fun getDrinkList(): Resource<List<Drink>> {

        return dataSource.generateDrinkList()
    }
}