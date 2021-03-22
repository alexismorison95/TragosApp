package com.alexis.morison.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.alexis.morison.tragosapp.AppDatabase
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.DataSource
import com.alexis.morison.tragosapp.databinding.FragmentFavouritesBinding
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.ui.viewmodel.MainViewModel
import com.alexis.morison.tragosapp.ui.viewmodel.ViewModelFactory
import com.alexis.morison.tragosapp.vo.Resource

class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory(
            RepoImplement(
                DataSource(AppDatabase.getDatabase(requireActivity().applicationContext))
            )
        )
    }

    private lateinit var binding: FragmentFavouritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouritesBinding.bind(view)

        viewModel.getFavouritesCocktails().observe(viewLifecycleOwner, { result ->

            when (result) {
                is Resource.Loading -> {

                }

                is Resource.Success -> {
                    Log.d("favourites_tag", "${result.data}")
                }

                is Resource.Failure -> {

                }
            }
        })
    }
}