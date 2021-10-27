package com.example.pokedex.infra.pokeapi

import com.example.pokedex.infra.pokeapi.entity.Pokemon
import com.example.pokedex.infra.pokeapi.entity.PokemonListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemon(): Response<PokemonListResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): Response<Pokemon>
}

object PokeApi {
    val retrofitService : PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}