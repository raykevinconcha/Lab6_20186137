package com.example.lab6_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class Memory extends AppCompatActivity {
    ImageButton b0;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton b9;
    ImageButton b10;
    ImageButton b11;
    ImageButton b12;
    ImageButton b13;
    ImageButton b14;
    ImageButton b15;
    Button vjugar;
    Button aleatorio;
    Button ayuda;
    ImageButton[] tablero = new ImageButton[16];
    int[] pokemones;
    int cubrir;
    ArrayList<Integer> imagenesd;
    ImageButton img;
    int pokemon_a, pokemon_b;
    boolean bloquear = false;
    final Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        iniciar_memoria();
    }
    private void subirImagen(){
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b13 = findViewById(R.id.b13);
        b14 = findViewById(R.id.b14);
        b15 = findViewById(R.id.b15);

        tablero[0] = b0;
        tablero[1] = b1;
        tablero[2] = b2;
        tablero[3] = b3;
        tablero[4] = b4;
        tablero[5] = b5;
        tablero[6] = b6;
        tablero[7] = b7;
        tablero[8] = b8;
        tablero[9] = b9;
        tablero[10] = b10;
        tablero[11] = b11;
        tablero[12] = b12;
        tablero[13] = b13;
        tablero[14] = b14;
        tablero[15] = b15;

        pokemones=new int[]{
                R.drawable.abra,R.drawable.abra___copia,
                R.drawable.aerodactyl,R.drawable.aerodactyl___copia,
                R.drawable.alakazam,R.drawable.alakazam___copia,
                R.drawable.arbok,R.drawable.arbok___copia,
                R.drawable.arcanine,R.drawable.arcanine___copia,
                R.drawable.articuno,R.drawable.articuno___copia,
                R.drawable.beedrill,R.drawable.beedrill___copia,
                R.drawable.bellsprout,R.drawable.bellsprout___copia,

        };
        cubrir=R.drawable.image_1614231146hr8;

    }
    private void volver_ajugar(){
        vjugar=findViewById(R.id.volver_a_jugar);
        vjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar_memoria();
            }
        });
    }
    private  void iniciar_memoria(){
        subirImagen();
        volver_ajugar();
        imagenesd=imagenes_aleatorias(pokemones.length);

    }

    private ArrayList<Integer> imagenes_aleatorias(int longitud){
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            s.add(i % longitud);
        }
        Collections.shuffle(s);
        return s;
    }

}