package com.example.pokeapi.comunication;


import com.example.pokeapi.Models.Pokemon;
import com.google.gson.Gson;


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
