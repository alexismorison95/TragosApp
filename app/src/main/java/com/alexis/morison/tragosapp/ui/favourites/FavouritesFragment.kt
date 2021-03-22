package com.alexis.morison.tragosapp.ui.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexis.morison.tragosapp.data.local.AppDatabase
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.DataSourceImplement
import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.databinding.FragmentFavouritesBinding
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.ui.MainAdapter
import com.alexis.morison.tragosapp.presentation.MainViewModel
import com.alexis.morison.tragosapp.presentation.ViewModelFactory
import com.alexis.morison.tragosapp.base.Resource

class FavouritesFragment : Fragment(R.layout.fragment_favourites),
    MainAdapter.OnDrinkClickListener {

    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory(
            RepoImplement(
                DataSourceImplement(AppDatabase.getDatabase(requireActivity().applicationContext))
            )
        )
    }

    private lateinit var binding: FragmentFavouritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouritesBinding.bind(view)

        setRecyclerView()

        setObservers()
    }

    private fun setObservers() {

        viewModel.getFavouritesCocktails().observe(viewLifecycleOwner, { result ->

            when (result) {
                is Resource.Loading -> {

                }

                is Resource.Success -> {

                    val favouritesList = result.data.map {

                        Cocktail(
                            it.drinkId,
                            it.name,
                            it.image,
                            it.description,
                            it.hasAlcohol,
                            it.ingredient1,
                            it.ingredient2,
                            it.ingredient3,
                            it.ingredient4,
                            it.ingredient5,
                            it.ingredient6,
                        )
                    }

                    binding.rvFavouritesDrinks.adapter = MainAdapter(requireContext(), favouritesList, this)
                }

                is Resource.Failure -> {

                }
            }
        })
    }

    private fun setRecyclerView() {

        binding.rvFavouritesDrinks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavouritesDrinks.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDrinkClick(cocktail: Cocktail, position: Int) {

        viewModel.deleteCocktail(cocktail)

        binding.rvFavouritesDrinks.adapter?.notifyItemRemoved(position)
    }
}