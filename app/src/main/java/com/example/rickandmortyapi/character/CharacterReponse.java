package com.example.rickandmortyapi.character;

import com.example.rickandmortyapi.network.model.BaseResponse;

import java.util.List;

public class CharacterReponse extends BaseResponse {

    private List<Character> results;

    public List<Character> getResults() {
        return results;
    }
}
