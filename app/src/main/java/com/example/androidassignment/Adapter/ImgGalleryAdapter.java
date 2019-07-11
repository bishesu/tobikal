package com.example.androidassignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidassignment.AfterclickingImage;
import com.example.androidassignment.Model.ImgModel;
import com.example.androidassignment.R;
import com.example.androidassignment.Retrofit.RetrofitHelper;
import com.example.androidassignment.Retrofit.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImgGalleryAdapter extends RecyclerView.Adapter<ImgGalleryAdapter.Holder> {
    private Context context;
    private List<ImgModel> imgModels;

    public ImgGalleryAdapter(Context context, List<ImgModel> imgModels) {
        this.context = context;
        this.imgModels = imgModels;
    }


    @NonNull
    @Override
    public ImgGalleryAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.design_index,viewGroup,false);
        return  new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgGalleryAdapter.Holder holder, int i) {
final ImgModel imgModel = imgModels.get(i);
//holder.descriptionforimage.setText(imgModel.getDescription());

String path= Url.Base_URL+"images/"+ imgModel.getImagename();
        Picasso.get().load(path).into(holder.homeImage);
//        holder.imgviewupload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = Url.Base_URL+"images"+imgModel.getImagename();
//
//                Intent intent = new Intent(context, AfterclickingImage.class);
//                intent.putExtra("Description",imgModel.getDescription());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {return imgModels.size();}

    public class Holder extends RecyclerView.ViewHolder {
        private TextView descriptionforimage;
        private ImageView homeImage;
        public Holder(@NonNull View itemView) {
            super(itemView);

            homeImage = itemView.findViewById(R.id.home_Image);

        }
    }


    }

