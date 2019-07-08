package com.example.androidassignment.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.R;
import com.squareup.picasso.Picasso;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ProfileGalleryAdapter extends  RecyclerView.Adapter<ProfileGalleryAdapter.GalleryHolder>{
Context context;
List<Cell> cellList;
String BASE_URL="http://10.0.2.2:3000/";

    public ProfileGalleryAdapter(Context context, List<Cell> cellList) {
        this.context = context;
        this.cellList = cellList;
    }

    @NonNull
    @Override
    public GalleryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell,viewGroup,false);
        return  new GalleryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileGalleryAdapter.GalleryHolder galleryHolder, int i) {
     final Cell cell=cellList.get(i);
//        Picasso.with(context).load(BASE_URL+"/images/"+cell.getImg()).into(galleryHolder.pic);
//        String  titleimage = cell.getTitleimg();
        String description = cell.getDescription();
//        Log.d("imagesnumber",cell.getImg());
        StrictMode();
        try{
            String imgurl= BASE_URL + cell.getImagename();
            URL url= new URL(imgurl);
            galleryHolder.pic.setImageBitmap(BitmapFactory.decodeStream((InputStream)url.getContent()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
//
//        galleryHolder.title.setText(titleimage);


    }

    @Override
    public int getItemCount() {
        return cellList.size();
    }

    public class GalleryHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        ImageView pic;
        public GalleryHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.titleimg);
            desc=itemView.findViewById(R.id.description);

        }
    }
    private void StrictMode(){
        android.os.StrictMode.ThreadPolicy policy= new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }

}
