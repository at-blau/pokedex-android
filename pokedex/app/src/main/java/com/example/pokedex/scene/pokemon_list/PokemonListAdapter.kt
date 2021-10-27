package com.example.pokedex.scene.pokemon_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ItemPokemonListBinding
import com.example.pokedex.infra.pokeapi.entity.PokemonListElement

class PokemonListAdapter(private val onClickPokemonListener: (PokemonListElement) -> Unit): RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    var pokemonList: List<PokemonListElement> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: ItemPokemonListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: PokemonListElement) {
            binding.pokemonName.text = pokemon.name
            binding.root.setOnClickListener {
                onClickPokemonListener(pokemon)
            }
        }
    }

    override fun getItemCount() = pokemonList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }
}