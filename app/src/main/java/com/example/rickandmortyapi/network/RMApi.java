package com.example.rickandmortyapi.network;

import com.example.rickandmortyapi.character.CharacterReponse;
import com.example.rickandmortyapi.network.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RMApi {
    @GET("character")
    Call<CharacterReponse> getCharacters();
}
