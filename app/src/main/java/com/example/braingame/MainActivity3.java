package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    int numOfImage, column,levelNo,row;
    ArrayList<String> imgList=new ArrayList<>();
    List<String> arrayList;
    ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView=findViewById(R.id.re_img);
        levelNo=getIntent().getIntExtra("level",0);


        if(levelNo>0 && levelNo<=3)
        {
            numOfImage=6;
            column=3;
            System.out.println("1-No of images="+numOfImage+"\t"+"num of Columns="+column);
        }
        else if(levelNo>3 && levelNo<=7)
        {
            numOfImage=8;
            column=4;
            System.out.println("2-No of images="+numOfImage+"\t"+"num of Columns="+column);
        }
        else if(levelNo>7)
        {
            numOfImage=10;
            column=5;
            row = 5;
            System.out.println("3-No of images="+numOfImage+"\t"+"num of Columns="+column);
        }
        String[] images = new String[0];
        try
        {
            images = getAssets().list("");
            imgList = new ArrayList<String>(Arrays.asList(images));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        arrayList= imgList.subList(0, numOfImage);
        arrayList.addAll(arrayList);

        Collections.shuffle(arrayList);
        imageAdapter =new ImageAdapter(this, arrayList);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity3.this,column);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(imageAdapter);

    }
}