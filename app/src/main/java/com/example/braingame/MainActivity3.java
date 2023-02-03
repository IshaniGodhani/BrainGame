package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    ImageView imageView;
    RecyclerView recyclerView;
    String[] level;
    int[] img={R.drawable.ardilla,R.drawable.bellota,R.drawable.bombon,R.drawable.coco,R.drawable.pm,
            R.drawable.caracol,R.drawable.galleta,R.drawable.gato,R.drawable.hamburguesa,
            R.drawable.margarita,R.drawable.paraguas,R.drawable.rosa,R.drawable.uvas};
    ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView=findViewById(R.id.grid_img);

        level=getIntent().getStringArrayExtra("level",level);

        imageAdapter =new ImageAdapter(this,img);
        recyclerView=findViewById(R.id.re_img);
        int num_of_cols=4;
//        gridLayoutManager.setOrientation(recyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this,num_of_cols));
        recyclerView.setAdapter(imageAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });





    }
}