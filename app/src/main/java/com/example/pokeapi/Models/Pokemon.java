package com.example.pokeapi.Models;

import java.io.Serializable;

public class Pokemon implements Serializable {


    private String id;
    private String nombrePoke;
    private String pokeImage;
    private String tipo;
    private int vida;
    private int defensa;
    private int ataque;
    private int velocidad;

    public Pokemon() {

    }

    public Pokemon(String id, String nombrePoke, String pokeImage, String tipo, int vida, int defensa, int ataque, int velocidad) {
        this.id = id;
        this.nombrePoke = nombrePoke;
        this.pokeImage = pokeImage;
        this.tipo = tipo;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.velocidad = velocidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePoke() {
        return nombrePoke;
    }

    public void setNombrePoke(String nombrePoke) {
        this.nombrePoke = nombrePoke;
    }

    public String getPokeImage() {
        return pokeImage;
    }

    public void setPokeImage(String pokeImage) {
        this.pokeImage = pokeImage;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
