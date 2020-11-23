package com.example.pokeapi.Models;

import java.io.Serializable;

public class ItemPokemon implements Serializable {
    private String id;
    private String pokeName;
    private String pokeImage;

    public ItemPokemon(){

    }

    public ItemPokemon(String id, String pokeName, String pokeImage) {
        this.id = id;
        this.pokeName = pokeName;
        this.pokeImage = pokeImage;
    }

    public String getPokeImage() {
        return pokeImage;
    }

    public void setPokeImage(String pokeImage) {
        this.pokeImage = pokeImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePoke() {
        return pokeName;
    }

    public void setNombrePoke(String nombrePoke) {
        this.pokeName = nombrePoke;
    }
}
