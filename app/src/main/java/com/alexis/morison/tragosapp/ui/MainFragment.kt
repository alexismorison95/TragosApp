package com.alexis.morison.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexis.morison.tragosapp.AppDatabase
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.data.DataSourceImplement
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.databinding.FragmentMainBinding
import com.alexis.morison.tragosapp.domain.RepoImplement
import com.alexis.morison.tragosapp.ui.viewmodel.MainViewModel
import com.alexis.morison.tragosapp.ui.viewmodel.ViewModelFactory
import com.alexis.morison.tragosapp.vo.Resource

class MainFragment : Fragment(R.layout.fragment_main), MainAdapter.OnDrinkClickListener {

    private lateinit var binding: FragmentMainBinding

    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory(
            RepoImplement(
                DataSourceImplement(AppDatabase.getDatabase(requireActivity().applicationContext))
            )
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        setRecyclerView()

        setSearchView()

        setObservers()

        binding.btnFavourites.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_favouritesFragment)
        }
    }

    private fun setObservers() {

        viewModel.fetchDrinkList.observe(viewLifecycleOwner, Observer { result ->

            when (result) {

                is Resource.Loading -> {

                    binding.rvTragos.adapter = null
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {

                    binding.progressBar.visibility = View.GONE
                    binding.rvTragos.adapter = MainAdapter(requireContext(), result.data, this)
                }

                is Resource.Failure -> {

                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setSearchView() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                viewModel.setCocktail(query!!)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun setRecyclerView() {

        binding.rvTragos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragos.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDrinkClick(drink: Drink, position: Int) {

        val bundle = Bundle()
        bundle.putParcelable(CocktailDetailFragment.DRINK_PARAM, drink)

        findNavController().navigate(R.id.action_mainFragment_to_cocktailDetailFragment, bundle)
    }
}