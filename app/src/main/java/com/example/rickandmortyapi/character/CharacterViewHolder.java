package com.example.rickandmortyapi.character;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickandmortyapi.R;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    ImageView ivAvatar;
    LinearLayout llCharacterContainer;
    TextView tvName,tvStatus,tvSpecies,tvGender,tvOrigin;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);

        ivAvatar=itemView.findViewById(R.id.ivAvatar);
        llCharacterContainer=itemView.findViewById(R.id.llCharacterContainer);
        tvName=itemView.findViewById(R.id.tvName);
        tvStatus=itemView.findViewById(R.id.tvStatus);
        tvSpecies=itemView.findViewById(R.id.tvSpecies);
        tvGender=itemView.findViewById(R.id.tvGender);
        tvOrigin=itemView.findViewById(R.id.tvOrigin);

    }

}
