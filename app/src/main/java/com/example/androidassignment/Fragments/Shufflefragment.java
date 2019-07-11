package com.example.androidassignment.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidassignment.APIs.GetImage;
import com.example.androidassignment.Adapter.ImgGalleryAdapter;
import com.example.androidassignment.Model.ImgModel;
import com.example.androidassignment.R;
import com.example.androidassignment.Retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Shufflefragment extends Fragment {
    private RecyclerView recyclerView;

    private GetImage getImage;
    private ImgGalleryAdapter imgGalleryAdapter;


    public Shufflefragment() {
        // Required empty public constructor
    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Shufflefragment.
//     */
//    // TODO: Rename and change types and number of parameters
//
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shufflefragment, container, false);

        recyclerView = view.findViewById(R.id.galleryindex);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getImage = RetrofitHelper.instance().create(GetImage.class);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Call<List<ImgModel>> gallery = getImage.getAllImages();
        gallery.enqueue(new Callback<List<ImgModel>>() {
            @Override
            public void onResponse(Call<List<ImgModel>> call, Response<List<ImgModel>> response) {
                imgGalleryAdapter = new ImgGalleryAdapter(getActivity(), response.body());
                recyclerView.setAdapter(imgGalleryAdapter);
            }

            @Override
            public void onFailure(Call<List<ImgModel>> call, Throwable t) {

            }
        });
    }
}

