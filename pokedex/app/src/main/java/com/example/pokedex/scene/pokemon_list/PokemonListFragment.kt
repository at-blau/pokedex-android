package com.example.pokedex.scene.pokemon_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonListFragmentBinding
import com.example.pokedex.infra.pokeapi.PokeApi

class PokemonListFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    private lateinit var viewModel: PokemonListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PokemonListFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        val adapter = PokemonListAdapter { pokemonListElement ->
            val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemonListElement.name)
            findNavController().navigate(action)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)

        viewModel.pokemonList.observe(viewLifecycleOwner, {
            adapter.pokemonList = it
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onViewCreated()
    }
}