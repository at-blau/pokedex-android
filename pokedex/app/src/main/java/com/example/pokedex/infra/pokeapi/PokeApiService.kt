package com.example.pokedex.infra.pokeapi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemon(): Response<String>
}

object PokeApi {
    val retrofitService : PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}