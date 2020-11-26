package com.example.pokeapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.Pokedex;
import com.example.pokeapi.R;

import java.util.ArrayList;


public class AdapterPokemon extends RecyclerView.Adapter<AdapterItemPokemon>{


    private ArrayList<ItemPokemon> listapokemon;
    private Pokedex pokedexActivity;
    private View view;


    public AdapterPokemon(ArrayList<ItemPokemon> lista, Pokedex pokedexActivity) {
        this.listapokemon = lista;
        this.pokedexActivity = pokedexActivity;

    }

    @NonNull
    @Override
    public AdapterItemPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,null, false);
        this.view = view;
        return new AdapterItemPokemon(view, pokedexActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemPokemon holder, int position) {
      ItemPokemon pokemon = this.listapokemon.get(position);
      holder.setPokeImage(pokemon.getPokeImage());
      holder.setPokename(pokemon.getNombrePoke());
      holder.onClickPokemon(view, pokemon);
    }

    @Override
    public int getItemCount() {
        return this.listapokemon.size();
    }
}