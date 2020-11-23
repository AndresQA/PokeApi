package com.example.pokeapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.R;

import java.util.ArrayList;


public class AdapterPokemon extends RecyclerView.Adapter<AdapterItemPokemon>{


    private ArrayList<ItemPokemon> listapokemon;


    public AdapterPokemon(ArrayList<ItemPokemon> lista) {
        this.listapokemon = lista;

    }

    @NonNull
    @Override
    public AdapterItemPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,null, false);
        return new AdapterItemPokemon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemPokemon holder, int position) {
      ItemPokemon pokemon = this.listapokemon.get(position);
      holder.setPokeImage(pokemon.getPokeImage());
      holder.setPokename(pokemon.getNombrePoke());
    }

    @Override
    public int getItemCount() {
        return this.listapokemon.size();
    }
}