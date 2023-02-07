package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity3 extends AppCompatActivity {
    ImageView imageView;
    RecyclerView recyclerView;
    String[] level;
    int levelNo;
    int imgs[]={R.drawable.ardilla,R.drawable.bellota,R.drawable.bombon,R.drawable.coco,
            R.drawable.caracol,R.drawable.galleta,R.drawable.ardilla,R.drawable.bellota,R.drawable.bombon,R.drawable.coco,
            R.drawable.caracol,R.drawable.galleta};
//    int img[]={R.drawable.ardilla,R.drawable.bellota,R.drawable.bombon,R.drawable.coco,
//            R.drawable.caracol,R.drawable.galleta,R.drawable.uvas,R.drawable.rosa,R.drawable.paraguas,
//            R.drawable.gato,R.drawable.margarita,R.drawable.ardilla,R.drawable.bellota,R.drawable.bombon,R.drawable.coco,
//            R.drawable.caracol,R.drawable.galleta,R.drawable.uvas,R.drawable.rosa,R.drawable.paraguas,
//            R.drawable.gato,R.drawable.margarita,};
    ArrayList<Integer> imgList;
    ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imgList = new ArrayList<Integer>();
        for (int index = 0; index <imgs.length; index++)
        {
            imgList.add(imgs[index]);
        }
        Collections.shuffle(imgList);


        imageAdapter =new ImageAdapter(this,imgList);
        recyclerView=findViewById(R.id.re_img);
        levelNo=getIntent().getIntExtra("level",0);
        if(levelNo<=3)
        {

            GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity3.this,4);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(imageAdapter);
        }
        else if(levelNo==4 && levelNo==5 && levelNo==6 && levelNo==7)
        {
            GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity3.this,5);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(imageAdapter);
        }
        else {
            GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity3.this,6);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(imageAdapter);
        }



    }
}