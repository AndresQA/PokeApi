package com.example.pokeapi.comunication;


import com.example.pokeapi.Models.Pokemon;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.UUID;


public class Actions {

    private HTTPSWebUtilDomi https;
    private Gson gson;

    public static String URL_PROYECT = "https://pokeapi.co/api/v2/pokemon/";

    //METODO DE SUSCRIPCION AL EVENTO


    public Actions() {
        https = new HTTPSWebUtilDomi();
        gson = new Gson();
    }


    public void buscarPokemon(String namePokemon, DataReadOb load){
        buscarPokemonDB(namePokemon, pokemonDB -> {
            if(pokemonDB != null){
                load.read(pokemonDB);
            }else{
                buscarPokeApi(namePokemon, pokemonApi -> {
                    if(pokemonApi != null){
                        load.read(pokemonApi);
                    }else{
                        load.read(null);
                    }
                });
            }
        });
    }

    private void buscarPokemonDB(String namePokemon, DataReadOb load){
        FirebaseFirestore fs =FirebaseFirestore.getInstance();
        fs.collection("pokemones").document(namePokemon).get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                DocumentSnapshot documentSnapshot = task.getResult();
                if(documentSnapshot.exists()){
                    Pokemon pokemon = documentSnapshot.toObject(Pokemon.class);
                    load.read(pokemon);
                }else{
                    load.read(null);
                }
            }
        });
    }

    private void buscarPokeApi(String namePokemon, DataReadOb load){
        new Thread(()->{

            String response = this.https.GETrequest(URL_PROYECT + namePokemon);

            if(response.equals("null") || response.equals("") ){
                load.read(null);
            }else{

                ItemDes itemDes = this.gson.fromJson(response, ItemDes.class);
                String uid = UUID.randomUUID().toString();
                String name = namePokemon;
                String tipo = itemDes.getAllTypes();
                int defensa =itemDes.pokeHabs("defense");
                int ataque = itemDes.pokeHabs("attack");
                int velocidad = itemDes.pokeHabs("speed");
                int vida = itemDes.pokeHabs("hp");
                String image = itemDes.getSprites().getImage();
                Pokemon pokemon = new Pokemon(uid, name, image, tipo, vida, defensa, ataque,velocidad );
                addpokemonFS(pokemon);
                load.read(pokemon);
            }

        }).start();
    }


    private void addpokemonFS(Pokemon pokemon){
        FirebaseFirestore firebaseFirestore =FirebaseFirestore.getInstance();
        firebaseFirestore.collection("pokemones").document(pokemon.getNombrePoke()).set(pokemon);
    }


}
