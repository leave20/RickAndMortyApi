package com.example.rickandmortyapi.character;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.rickandmortyapi.BaseActivity;
import com.example.rickandmortyapi.R;
import com.example.rickandmortyapi.commons.Constants;

import org.w3c.dom.Text;

public class CharacterDetailActivity extends BaseActivity {

    String name, gender, status, species, avatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        loadExtras();
        loadViews();
    }

    private void loadExtras() {
        name = getIntent().getStringExtra(Constants.EXTRA_NAME);
        gender = getIntent().getStringExtra(Constants.EXTRA_GENDER);
        status = getIntent().getStringExtra(Constants.EXTRA_STATUS);
        species = getIntent().getStringExtra(Constants.EXTRA_SPECIES);
        avatar = getIntent().getStringExtra(Constants.EXTRA_AVATAR);
    }

    private void loadViews() {
        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        Glide.with(this)
                .load(avatar)
                .into(ivAvatar);

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);
        TextView tvSpecies = findViewById(R.id.tvSpecies);
        tvSpecies.setText(species);
        Button btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(view -> addToFavoritess());
        ImageView ivGender = findViewById(R.id.ivGender);


        if (gender.toLowerCase().equals("male"))
            ivGender.setImageResource(R.mipmap.icmaledalexd_foreground);
        else
            ivGender.setImageResource(R.mipmap.icfemaledalexd_foreground);

        ImageView ivStatus = findViewById(R.id.ivStatus);

        if (status.toLowerCase().equals("dead"))
            ivStatus.setVisibility(View.VISIBLE);
        else
            ivStatus.setVisibility(View.GONE);

        getSupportActionBar().setTitle("Personaje: "+name);
    }

    private void addToFavoritess() {

    }
}
