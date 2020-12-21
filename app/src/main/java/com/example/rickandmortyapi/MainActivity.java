package com.example.rickandmortyapi;



import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rickandmortyapi.character.CharacterActivity;

public class MainActivity extends BaseActivity {

    private enum BTEvent {
        CHARACTERS, FAVS, EPISODES, PLACES
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btCharacters).setOnClickListener(view -> buttonEvent(BTEvent.CHARACTERS));
        findViewById(R.id.btPlaces).setOnClickListener(view -> buttonEvent(BTEvent.PLACES));
        findViewById(R.id.btEpisodes).setOnClickListener(view -> buttonEvent(BTEvent.EPISODES));
        findViewById(R.id.btFavorites).setOnClickListener(view -> buttonEvent(BTEvent.FAVS));

        ImageView ivTest = findViewById(R.id.ivTest);
        Glide.with(this).load("https://p4.wallpaperbetter.com/wallpaper/178/471/787/rick-and-morty-run-the-jewels-vector-graphics-wallpaper-preview.jpg").into(ivTest);



    }


    private void buttonEvent(BTEvent btEvent) {



        if (btEvent == BTEvent.CHARACTERS) {
          Intent  intent = new Intent(this, CharacterActivity.class);
            startActivity(intent);
        }


    }
}