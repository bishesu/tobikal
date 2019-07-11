package com.example.androidassignment;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AfterclickingImage extends AppCompatActivity {
    private ImageView photo;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterclicking_image);

        photo = findViewById(R.id.imgviewuploadafterclick);
        desc = findViewById(R.id.descriptionforimageafterclick);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String img=bundle.getString("image","");
            //Picasso.with().load(img).into(photo);
            String description = bundle.getString("Description","");
            desc.setText(description);
        }
    }
}
