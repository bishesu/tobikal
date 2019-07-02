package com.example.androidassignment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileGalleryAdapter extends  RecyclerView.Adapter<ProfileGalleryAdapter.GalleryHolder>{
Context context;
List<Cell> cellList;
String BASE_URL="http://10.0.2.2:3000";

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
    public void onBindViewHolder(@NonNull GalleryHolder galleryHolder, int i) {
    final Cell cell=cellList.get(i);
        Picasso.with(context).load(BASE_URL+"/images/"+cell.getImg()).into(galleryHolder.pic);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GalleryHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        public GalleryHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.img);
        }
    }

}
