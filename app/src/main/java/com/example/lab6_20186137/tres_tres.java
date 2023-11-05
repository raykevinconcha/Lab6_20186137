package com.example.lab6_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class tres_tres extends AppCompatActivity {
    private int cuadricula = 3;
    private GridLayout imagen;
    private Button comenzar;
    private List<Bitmap> imageParts;
    private int e;
    private SharedPreferences prefs;
    private static final String PREFS_NAME = "Puzzle_P";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_tres);
        imagen=findViewById(R.id.imagen);
        comenzar=findViewById(R.id.comenzar);
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });
        iniciarjuego();

    }

    private void iniciarjuego(){
        imageParts = getImageParts(R.drawable.yuu);
        imagen.removeAllViews();
        imagen.setColumnCount(cuadricula);
        e=cuadricula*cuadricula-1;

        for (int i = 0; i < imageParts.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(imageParts.get(i));
            imagen.addView(imageView);
        }
    }
    private List<Bitmap> getImageParts(int id){
        Bitmap fto= BitmapFactory.decodeResource(getResources(),id);
        List<Bitmap> parts=new ArrayList<>();
        int partWidth = fto.getWidth() / cuadricula;
        int partHeight = fto.getHeight() / cuadricula;

        for (int y = 0; y < cuadricula; y++) {
            for (int x = 0; x < cuadricula; x++) {
                if (y == cuadricula - 1 && x == cuadricula - 1) {
                    continue;
                }
                int sx = x * partWidth;
                int sy = y * partHeight;
                Bitmap part = Bitmap.createBitmap(fto, sx, sy, partWidth, partHeight);
                parts.add(part);
            }
        }
        return parts;

    }
    private void go(){
        for (int i = 0; i < 8; i++) {
            int direction = (int) (Math.random() * 4);
            int[] fila = {0, -1, 0, 1};
            int[] colum = {-1, 0, 1, 0};

            int currentRow = e / cuadricula;
            int currentCol = e % cuadricula;
            int nfila = currentRow + fila[direction];
            int ncolum = currentCol + colum[direction];

            if (nfila >= 0 && nfila < cuadricula && ncolum >= 0 && ncolum < cuadricula) {
                int p = nfila * cuadricula + ncolum;
                aleatorio(e, p);
                e = p;
            }
        }
    }
    private void aleatorio(int e ,int p ){
        Bitmap b = BitmapFactory.decodeResource(getResources(), android.R.color.transparent);
        ImageView i = (ImageView) imagen.getChildAt(e);
        ImageView newImageView = (ImageView) imagen.getChildAt(p);

        Drawable tdraw = i.getDrawable();
        i.setImageDrawable(newImageView.getDrawable());
        newImageView.setImageBitmap(b);

    }

}
