package com.alexis.morison.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alexis.morison.tragosapp.R
import com.alexis.morison.tragosapp.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.btnGoToDetails.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_cocktailDetailFragment)
        }
    }
}