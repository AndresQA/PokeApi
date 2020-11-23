package com.example.pokeapi.Adapter;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokeapi.Descripcionpokemon;
import com.example.pokeapi.Pokedex;
import com.example.pokeapi.R;

public class AdapterItemPokemon extends RecyclerView.ViewHolder {
    private ImageView pokemon_img;
    private TextView namepoke_txt;


    public AdapterItemPokemon(@NonNull View itemView) {
        super(itemView);
        pokemon_img = itemView.findViewById(R.id.pokemon_img);
        namepoke_txt = itemView.findViewById(R.id.namepoke_txt);
        itemView.setOnClickListener(this::irPokemon);
    }

    public void irPokemon(View v){
       // Intent intent = new Intent(this, Descripcionpokemon.class);
       // intent.putExtra("trainer", trainer);

    }

    public void setPokeImage(String pokeImage){
        Glide.with(pokemon_img).load(pokeImage).into(pokemon_img);
    }

    public void setPokename(String pokename){
        this.namepoke_txt.setText(pokename);
    }
}
