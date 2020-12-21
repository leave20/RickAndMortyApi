package com.example.rickandmortyapi.character;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickandmortyapi.BaseActivity;
import com.example.rickandmortyapi.R;
import com.example.rickandmortyapi.network.RMLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterActivity extends BaseActivity {

    RecyclerView rvCharacters;
    TextView tvEmptyList;
    List<Character> characters=new ArrayList<>();
    CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_character);



        rvCharacters = findViewById(R.id.rvCharacters);
        rvCharacters.setHasFixedSize(true);

        tvEmptyList = findViewById(R.id.tvEmptyList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCharacters.setLayoutManager(linearLayoutManager);

        characterAdapter=new CharacterAdapter(this, characters);

        rvCharacters.setAdapter(characterAdapter);

        loadCharacterFromNetwork();


    }

    private void loadCharacterFromNetwork() {

        showProgress("cargando personajes ...");
        RMLoader.getApi().getCharacters().enqueue(new Callback<CharacterReponse>() {
            @Override
            public void onResponse(Call<CharacterReponse> call, Response<CharacterReponse> response) {
                hideProgress();
                if (response.isSuccessful()&& response.body().getResults()!=null){
                    characters.clear();
                    characters.addAll(response.body().getResults());
                    characterAdapter.notifyDataSetChanged();
                }else{
                    showOKDialog("Error al cargar los personajes");
                }

            }

            @Override
            public void onFailure(Call<CharacterReponse> call, Throwable t) {

                hideProgress();
                showOKDialog("Error al cargar los personajes");
            }
        });

    }


}
