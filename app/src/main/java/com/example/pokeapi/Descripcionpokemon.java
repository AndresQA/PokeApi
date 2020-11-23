package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Descripcionpokemon extends AppCompatActivity {

    private TextView defensa_txt;
    private TextView ataque_txt;
    private TextView velocidad_txt;
    private TextView vida_txt;
    private Button soltar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionpokemon);

        defensa_txt = findViewById(R.id.defensa_txt);
        ataque_txt = findViewById(R.id.ataque_txt);
        velocidad_txt = findViewById(R.id.velocidad_txt);
        vida_txt = findViewById(R.id.vida_txt);
        soltar_btn = findViewById(R.id.soltar_btn);

        soltar_btn.setOnClickListener(this::soltarPokemon);

    }

    public void soltarPokemon(View v){

    }
}