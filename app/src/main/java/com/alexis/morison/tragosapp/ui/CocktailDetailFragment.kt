package com.alexis.morison.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.model.Drink

private const val DRINK_PARAM = "drink"

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            drink = it.getParcelable(DRINK_PARAM)!!
        }

        Log.d("TAG", "onCreate: ${drink.toString()}")
    }



}