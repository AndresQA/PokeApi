package com.example.pokeapi.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Trainer implements Serializable {
    private String id;
    private String name;
    private ArrayList<ItemPokemon> mispokemones;


    public Trainer(){

    }

    public Trainer(String id, String name, ArrayList<ItemPokemon> mispokemones) {
        this.id = id;
        this.name = name;
        this.mispokemones = mispokemones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ItemPokemon> getMispokemones() {
        return mispokemones;
    }

    public void setMispokemones(ArrayList<ItemPokemon> mispokemones) {
        this.mispokemones = mispokemones;
    }
}
