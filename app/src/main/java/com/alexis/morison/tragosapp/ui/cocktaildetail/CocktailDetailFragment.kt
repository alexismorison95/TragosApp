package com.alexis.morison.tragosapp.ui.cocktaildetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.alexis.morison.tragosapp.data.local.AppDatabase
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.DataSourceImplement
import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.data.model.DrinkEntity
import com.alexis.morison.tragosapp.databinding.FragmentCocktailDetailBinding
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.presentation.MainViewModel
import com.alexis.morison.tragosapp.presentation.ViewModelFactory
import com.google.android.material.chip.Chip
import com.squareup.picasso.Picasso

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {

    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory(
            RepoImplement(
                DataSourceImplement(AppDatabase.getDatabase(requireActivity().applicationContext))
            )
        )
    }

    private lateinit var cocktail: Cocktail

    private lateinit var binding: FragmentCocktailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {

            cocktail = it.getParcelable(DRINK_PARAM)!!
        }
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

        binding.btnSaveCocktail.setOnClickListener {

            viewModel.saveCocktail(DrinkEntity(
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
            ))

            Toast.makeText(requireContext(), "Add to favourites", Toast.LENGTH_SHORT).show()
        }
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