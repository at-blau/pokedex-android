package com.example.pokedex.scene.pokemon_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonListFragmentBinding
import com.example.pokedex.infra.pokeapi.PokeApi

class PokemonListFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    private lateinit var viewModel: PokemonListViewModel
    private val adapter = PokemonListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PokemonListFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            PokeApi.retrofitService.getPokemon().body()?.let {
                adapter.pokemonList = it.results
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}