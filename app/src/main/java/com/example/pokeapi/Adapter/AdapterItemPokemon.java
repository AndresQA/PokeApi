package com.example.pokeapi.Adapter;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokeapi.Descripcionpokemon;
import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.Models.Pokemon;
import com.example.pokeapi.Pokedex;
import com.example.pokeapi.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdapterItemPokemon extends RecyclerView.ViewHolder {
    private ImageView pokemon_img;
    private TextView namepoke_txt;
    private Pokedex pokedexActivity;


    public AdapterItemPokemon(@NonNull View itemView, Pokedex pokedexActivity) {
        super(itemView);
        pokemon_img = itemView.findViewById(R.id.pokemon_img);
        namepoke_txt = itemView.findViewById(R.id.namepoke_txt);
        this.pokedexActivity = pokedexActivity;
    }

    public void irPokemon(View v, ItemPokemon pokemon){

        FirebaseFirestore.getInstance().collection("pokemones").document(pokemon.getNombrePoke()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Pokemon name = task.getResult().toObject(Pokemon.class);
                name.setId(pokemon.getId());

              //  Toast.makeText(pokedexActivity, "" + name.getNombrePoke(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this.pokedexActivity, Descripcionpokemon.class);
                intent.putExtra("trainer", this.pokedexActivity.trainer);
                intent.putExtra("pokemon", name);
               this.pokedexActivity.startActivity(intent);
            }
        });


    }

    public void onClickPokemon(View v, ItemPokemon pokemon){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokedexActivity.runOnUiThread(()->{ irPokemon(v, pokemon);});

            }
        });
    }

    public void setPokeImage(String pokeImage){
        Glide.with(pokemon_img).load(pokeImage).into(pokemon_img);
    }

    public void setPokename(String pokename){
        this.namepoke_txt.setText(pokename);
    }
}
