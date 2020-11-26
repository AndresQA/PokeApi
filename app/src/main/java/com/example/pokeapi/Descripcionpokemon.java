package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.Models.Pokemon;
import com.example.pokeapi.Models.Trainer;
import com.google.firebase.firestore.FirebaseFirestore;

public class Descripcionpokemon extends AppCompatActivity {

    private TextView defensa_txt;
    private TextView ataque_txt;
    private TextView velocidad_txt;
    private TextView vida_txt;
    private TextView tipoPokemon_txt;
    private TextView namepokemon_txt;
    private ImageView pokemondetalle_img;
    private Button soltar_btn;
    private Pokemon pokemon;
    private Trainer trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionpokemon);

        if(this.getIntent().getExtras() != null){
            Trainer trainer = (Trainer) this.getIntent().getSerializableExtra("trainer");
            Pokemon pokemon = (Pokemon) this.getIntent().getSerializableExtra("pokemon");
            this.trainer = trainer;
            this.pokemon = pokemon;
        }

        defensa_txt = findViewById(R.id.defensa_txt);
        ataque_txt = findViewById(R.id.ataque_txt);
        velocidad_txt = findViewById(R.id.velocidad_txt);
        vida_txt = findViewById(R.id.vida_txt);
        soltar_btn = findViewById(R.id.soltar_btn);
        tipoPokemon_txt = findViewById(R.id.tipoPokemon_txt);
        namepokemon_txt = findViewById(R.id.namepokemon_txt);
        pokemondetalle_img = findViewById(R.id.pokemondetalle_img);


        soltar_btn.setOnClickListener(this::soltarPokemon);

        if (this.pokemon != null) {
           // Toast.makeText(this, ""+pokemon.getDefensa(), Toast.LENGTH_SHORT).show();
            defensa_txt.setText(pokemon.getDefensa()+"");
           ataque_txt.setText(pokemon.getAtaque()+"");
           velocidad_txt.setText(pokemon.getVelocidad()+"");
           vida_txt.setText(pokemon.getVida()+"");
           tipoPokemon_txt.setText(pokemon.getTipo());
            namepokemon_txt.setText(pokemon.getNombrePoke());
           Glide.with(this.pokemondetalle_img).load(pokemon.getPokeImage()).into(this.pokemondetalle_img);
        }

    }

    public void soltarPokemon(View v){
        for(int i =0 ; i < this.trainer.getMispokemones().size(); i++){
            ItemPokemon itemPokemon = this.trainer.getMispokemones().get(i);
            if(itemPokemon.getId().equals(this.pokemon.getId())){
                this.trainer.getMispokemones().remove(i);
                i = this.trainer.getMispokemones().size();
            }
        }

        FirebaseFirestore fs = FirebaseFirestore.getInstance();
        fs.collection("trainers").document(this.trainer.getName())
                .collection("pokemones")
                .document(this.pokemon.getId()).delete()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(this, Pokedex.class);
                        intent.putExtra("trainer", this.trainer);
                        startActivity(intent);
                    }
                });
    }


}