package com.example.pokedex.scene.pokemon_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.pokedex.databinding.FragmentPokemonDetailBinding

class PokemonDetailFragment : Fragment() {
    private val args: PokemonDetailFragmentArgs by navArgs()

    lateinit var viewModel: PokemonDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)

        val viewModelFactory = PokemonDetailViewModelFactory(args.pokemonName)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PokemonDetailViewModel::class.java)

        viewModel.pokemon.observe(viewLifecycleOwner) {
            binding.pokemonName.text = it.name
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onViewCreated()
    }
}