package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pokeapi.Models.ItemPokemon;
import com.example.pokeapi.Models.Trainer;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button login_btn;
    private EditText entrenador_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        }, 1);

        entrenador_txt = findViewById(R.id.entrenador_txt);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(this::ingresar);
    }

    public void ingresar(View v){

        String nameEntrenador = this.entrenador_txt.getText().toString().toLowerCase();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("trainers")
                .document(nameEntrenador)
                .get()
                .addOnCompleteListener((task)->{
                    if(task.isSuccessful()){
                        DocumentSnapshot document = task.getResult();
                        if(document.exists()){
                            Trainer trainer = document.toObject(Trainer.class);
                            this.goPokedex(trainer);
                        }else{
                            ArrayList<ItemPokemon> pokemones = new ArrayList<>();
                            String id = UUID.randomUUID().toString();
                            Trainer trainer = new Trainer(id, nameEntrenador, pokemones);

                            firebaseFirestore.collection("trainers")
                                    .document(nameEntrenador).set(trainer).addOnCompleteListener((proceso)->{
                                if(proceso.isSuccessful()){
                                    this.goPokedex(trainer);
                                }
                            });
                        }


                    }else{
                        Toast.makeText(this, "Se ha producido un Error", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void goPokedex(Trainer trainer) {
        Intent intent = new Intent(this, Pokedex.class);
        intent.putExtra("trainer", trainer);
        startActivity(intent);
    }
}