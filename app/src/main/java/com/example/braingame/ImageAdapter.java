package com.example.braingame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    Context context;
    List<String> imgList;
    Runnable runnable;
    View view;
    int click=1,pos1=0,pos2=0;
       public ImageAdapter(Context context, List<String> imgList) {
        this.context=context;
        this.imgList=imgList;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.grid_images,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InputStream inputstream = null;
        try
        {
            inputstream = context.getAssets().open(imgList.get(position));
            System.out.println("No of Images="+imgList.size());
            System.out.println("imgList Position="+imgList.get(position));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        holder.imageView.setImageDrawable(drawable);

        int interval=2000;
        Handler handler=new Handler();
        runnable = new Runnable() {
            public void run() {
                holder.mask.setVisibility(View.VISIBLE);
            }
        };
        handler.postAtTime(runnable,System.currentTimeMillis());
        handler.postDelayed(runnable, interval);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click == 1) {
                    holder.mask.setVisibility(View.INVISIBLE);
                    pos1 = holder.getAdapterPosition();
                    view= holder.mask;
                    click=3;
                    runnable = new Runnable()
                    {
                        public void run() {
                            click = 2;
                        }
                    };
                    System.out.println("First Click");
                    handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                    handler.postDelayed(runnable, 100);
                }
                if (click == 2) {
                    holder.mask.setVisibility(View.INVISIBLE);
                    pos2 = holder.getAdapterPosition();
                    click = 3;
                    System.out.println("Second Click");
                    if (imgList.get(pos1).equals(imgList.get(pos2))) {
                        runnable = new Runnable() {
                            public void run() {
                                click = 1;
                            }
                        };
                        System.out.println("Matched");

                        handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                        handler.postDelayed(runnable, 500);
                    } else {
                        System.out.println("not match");
                        runnable = new Runnable() {
                            public void run() {
                                holder.mask.setVisibility(View.VISIBLE);
                                view.setVisibility(View.VISIBLE);
                                click = 1;
                            }
                        };
                        handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                        handler.postDelayed(runnable, 500);
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View mask;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.grid_img);
            textView=itemView.findViewById(R.id.level);
            mask=itemView.findViewById(R.id.mask);
            relativeLayout=itemView.findViewById(R.id.relative);
        }
    }
}
