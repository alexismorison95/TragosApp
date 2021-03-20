package com.alexis.morison.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.databinding.FragmentCocktailDetailBinding
import com.google.android.material.chip.Chip
import com.squareup.picasso.Picasso

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {

    private lateinit var cocktail: Drink

    private lateinit var binding: FragmentCocktailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            cocktail = it.getParcelable(DRINK_PARAM)!!
        }

        Log.d("detail_tag", "onCreate: ${cocktail.toString()}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCocktailDetailBinding.bind(view)

        Picasso.get()
            .load(cocktail.image)
            .into(binding.imgCocktail)

        binding.textTitle.text = cocktail.name
        binding.textDescription.text = cocktail.description
        binding.textAlcoholic.text = cocktail.hasAlcohol

        getIngredients()
    }

    private fun getIngredients() {

        if (cocktail.ingredient1 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient1

            binding.chipGroup.addView(chip)
        }

        if (cocktail.ingredient2 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient2

            binding.chipGroup.addView(chip)
        }

        if (cocktail.ingredient3 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient3

            binding.chipGroup.addView(chip)
        }

        if (cocktail.ingredient4 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient4

            binding.chipGroup.addView(chip)
        }

        if (cocktail.ingredient5 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient5

            binding.chipGroup.addView(chip)
        }

        if (cocktail.ingredient6 != null) {

            val chip = Chip(requireContext())
            chip.text = cocktail.ingredient6

            binding.chipGroup.addView(chip)
        }
    }


    companion object {

        const val DRINK_PARAM = "drink"
    }
}