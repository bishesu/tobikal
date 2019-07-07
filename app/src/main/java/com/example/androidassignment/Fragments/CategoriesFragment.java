package com.example.androidassignment.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidassignment.APIs.FeedbackApi;
import com.example.androidassignment.Model.FeedbackModel;
import com.example.androidassignment.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {
private EditText fullname;
private EditText email;
private EditText contact;
private EditText description;
Button btnfeedback;
FeedbackApi feedbackApi;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories, container, false);
        fullname = view.findViewById(R.id.fullnamefeedback);
        email = view.findViewById(R.id.emailfeedback);
        contact = view.findViewById(R.id.contactfeed);
        description = view.findViewById(R.id.description);
        btnfeedback=view.findViewById(R.id.btnfeedback);

        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<String> call=feedbackApi.sendfeedback(new FeedbackModel(fullname.getText().toString()
                        ,description.getText().toString()
                        ,email.getText().toString()
                        ,contact.getText().toString()));
                System.out.println("lllll"+fullname.getText().toString());
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getActivity(), response.body(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
                return view;

    }




}
