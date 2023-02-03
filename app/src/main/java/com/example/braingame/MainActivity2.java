package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String[] level={"Level 1","Level 2","Level 3","Level 4","Level 5",
            "Level 6","Level 7","Level 8","Level 9","Level 10"};
//    TextView level_title;
    RecyclerView recyclerView;

    RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        level_title=findViewById(R.id.level);

        recyclerAdapter=new RecyclerAdapter(this,level);
        recyclerView=findViewById(R.id.level_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity2.this);
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("level",level);

                startActivity(intent);
            }
        });

    }
}