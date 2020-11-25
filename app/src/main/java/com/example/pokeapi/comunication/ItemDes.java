package com.example.pokeapi.comunication;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDes {


    @SerializedName("types")
    private List<TypePokemon> types;
    @SerializedName("stats")
    private List<HabPokemon> habilidades;
    @SerializedName("sprites")
    private PokemonSprite sprites;



    public ItemDes() { }


    public ItemDes(PokemonSprite sprites, List<HabPokemon> habilidades, List<TypePokemon> types) {
        this.sprites = sprites;
        this.habilidades = habilidades;
        this.types = types;
    }

    public String getAllTypes(){
        String types = "";
        for (int i = 0; i < this.types.size(); i++){
            TypePokemon type = this.types.get(i);
            if(i ==0){
                types = type.getType().getName();
            }else{
                types = types + ", " + type.getType().getName();
            }
        }

        return types;
    }

    public int getHabilidadesName(String name){
        int value =0;
        for (int i = 0; i < this.habilidades.size(); i++){
            HabPokemon habilidad = this.habilidades.get(i);
            if(habilidad.getStat().getName().equals(name)){
                value = habilidad.getValue();
                i = this.habilidades.size();
            }
        }
        return value;
    }

    public PokemonSprite getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprite sprites) {
        this.sprites = sprites;
    }

    public List<HabPokemon> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabPokemon> habilidades) {
        this.habilidades = habilidades;
    }

    public List<TypePokemon> getTypes() {
        return types;
    }

    public void setTypes(List<TypePokemon> types) {
        this.types = types;
    }

    public class TypePokemon{

        @SerializedName("type")
        private TypePokemonTipo type;

        public TypePokemonTipo getType() {
            return type;
        }

        public class TypePokemonTipo{
            @SerializedName("name")
            private String name;

            public String getName() {
                return name;
            }
        }
    }

    public class HabPokemon{
        @SerializedName("base_stat")
        private int value;

        @SerializedName("stat")
        private HabPokemonStat stat;

        public int getValue() {
            return value;
        }

        public HabPokemonStat getStat() {
            return stat;
        }

        public class HabPokemonStat{
            @SerializedName("name")
            private String name;

            public String getName() {
                return name;
            }
        }
    }

    public class PokemonSprite{
        @SerializedName("front_default")
        private String image;

        public String getImage() {
            return image;
        }
    }


}






