package com.example.pokeapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pokeapi.Adapter.AdapterPokemon;
import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.Models.Pokemon;
import com.example.pokeapi.Models.Trainer;
import com.example.pokeapi.comunication.Actions;
import com.example.pokeapi.comunication.DataReadOb;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pokedex extends AppCompatActivity {
    private RecyclerView listapokemon;
    private EditText namepokemon_txt;
    private EditText buscarpokimon_txt;
    private Button atrapar_btn;
    private Button buscar_btn;
    private ArrayList<ItemPokemon> pokemones;
    private AdapterPokemon adapterPokemon;
    private Actions serverpokemon;
    public Trainer trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        pokemones = new ArrayList<>();
        if(this.getIntent().getExtras() != null){
            Trainer trainer = (Trainer) this.getIntent().getSerializableExtra("trainer");
            this.trainer = trainer;
            this.pokemones = trainer.getMispokemones();
            Toast.makeText(this, "Bienvenido " + trainer.getName() + " " + trainer.getMispokemones().size(), Toast.LENGTH_SHORT).show();
        }

        serverpokemon = new Actions();

        listapokemon = findViewById(R.id.listapokemon);
        this.listapokemon.setLayoutManager(new LinearLayoutManager(this));

        namepokemon_txt = findViewById(R.id.namepokemon_txt);
        buscarpokimon_txt = findViewById(R.id.buscarpokimon_txt);
        atrapar_btn = findViewById(R.id.atrapar_btn);
        buscar_btn = findViewById(R.id.buscar_btn);

        atrapar_btn.setOnClickListener(this::atraparPokemon);
        buscar_btn.setOnClickListener(this::buscarPokimon);

        adapterPokemon = new AdapterPokemon(pokemones, this);
        listapokemon.setAdapter(adapterPokemon);
    }

    public void atraparPokemon(View v){
        String namepokemon = namepokemon_txt.getText().toString().toLowerCase();
        if (namepokemon.equals("") == false) {
            serverpokemon.buscarPokemon(namepokemon, pokemon -> {
                namepokemon_txt.setText("");
                if (pokemon != null){
                    FirebaseFirestore fs = FirebaseFirestore.getInstance();
                    String nameEntrenador = trainer.getName();
                    ItemPokemon itemPokemon = new ItemPokemon(pokemon.getId(), pokemon.getNombrePoke(), pokemon.getPokeImage());
                    trainer.getMispokemones().add(itemPokemon);
                    //fs.collection("trainers").document(nameEntrenador).set(trainer);

                    String uid = UUID.randomUUID().toString();
                    itemPokemon.setId(uid);

                    pokemones = this.trainer.getMispokemones();
                    adapterPokemon = new AdapterPokemon(pokemones, this);
                    listapokemon.setAdapter(adapterPokemon);

                    fs.collection("trainers").document(this.trainer.getName())
                            .collection("pokemones").document(uid).set(itemPokemon);
                }

            });

        }
    }

    public void buscarPokimon(View v){
        String namePokemon = this.buscarpokimon_txt.getText().toString();
        //  Toast.makeText(this, "Buscando a " + namePokemon, Toast.LENGTH_SHORT).show();
        if(!namePokemon.equals("")){
            Pokedex pokedex = this;
            FirebaseFirestore.getInstance().collection("trainers").document(this.trainer.getName())
                    .collection("pokemones").whereEqualTo("nombrePoke", namePokemon).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    ArrayList<ItemPokemon> itemPokemons = new ArrayList<>();

                    for (DocumentSnapshot doc : value) {
                        ItemPokemon poke = doc.toObject(ItemPokemon.class);
                        itemPokemons.add(poke);

                    }

                    adapterPokemon = new AdapterPokemon(itemPokemons, pokedex);
                    listapokemon.setAdapter(adapterPokemon);


                }
            });
        }else{
            Toast.makeText(this, "Todos los Pokemones", Toast.LENGTH_SHORT).show();
            adapterPokemon = new AdapterPokemon(this.trainer.getMispokemones(), this);
            listapokemon.setAdapter(adapterPokemon);
        }
    }


}