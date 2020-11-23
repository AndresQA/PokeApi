package com.example.pokeapi.comm;

import android.annotation.SuppressLint;


import com.example.pokeapi.Models.Pokemon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
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

    public void buscarPokemon(String name, DataReadOb load){
        /*
        String response = this.https.GETrequest(URL_PROYECT + name);
        if(response.equals("null") ){

        }else{

            Pokemon pokemon = new Pokemon(
                    "xxxxx",
                    "ditto",
                    "normal",
                    "034",
                    "034", "034", "034", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png");

           // gson.fromJson(response, User.class);

            load.read(pokemon);
        }
        */

        Pokemon pokemon = new Pokemon(
                "xxxxx",
                "ditto",
                "normal",
                "034",
                "034", "034", "034", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png");

        // gson.fromJson(response, User.class);

        load.read(pokemon);
    }



}
