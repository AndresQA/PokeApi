package com.example.pokeapi.Models;

public class Pokemon {


    private String id;
    private String nombrePoke;
    private String pokeImage;
    private String tipo;
    private String vida;
    private String defensa;
    private String ataque;
    private String velocidad;

    public Pokemon() {

    }

    public Pokemon(String id, String nombrePoke, String tipo, String vida, String defensa, String ataque, String velocidad, String pokeImage) {
        this.id = id;
        this.nombrePoke = nombrePoke;
        this.tipo = tipo;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.velocidad = velocidad;
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
        return nombrePoke;
    }

    public void setNombrePoke(String nombrePoke) {
        this.nombrePoke = nombrePoke;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
}
