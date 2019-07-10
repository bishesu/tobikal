package com.example.androidassignment.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidassignment.APIs.GetImage;
import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.R;
import com.example.androidassignment.Retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Shufflefragment extends Fragment {
private RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;




//    public Shufflefragment() {
//        // Required empty public constructor
//    }
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
        View view= inflater.inflate(R.layout.fragment_shufflefragment, container, false);

        recyclerView = view.findViewById(R.id.galleryindex);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        final GetImage getImage= RetrofitHelper.instance().create(GetImage.class);
        SharedPreferences  preferences=getActivity().getSharedPreferences("tokenstore",0);
        String id=preferences.getString("userId",null);

        Call<List<Cell>> call=getImage.getImages(id);
        call.enqueue(new Callback<List<Cell>>() {
            @Override
            public void onResponse(Call<List<Cell>> call, Response<List<Cell>> response) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Cell>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

         return view;
    }

}

