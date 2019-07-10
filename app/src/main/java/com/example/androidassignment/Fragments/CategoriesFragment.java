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
import com.example.androidassignment.Retrofit.RetrofitHelper;

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
//FeedbackApi feedbackApi;

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
                FeedbackApi feedbackApi= RetrofitHelper.instance().create(FeedbackApi.class);
                String fname= fullname.getText().toString();
                String mail = email.getText().toString();
                String desc = description.getText().toString();
                String cont = contact.getText().toString();

FeedbackModel feedbackModel = new FeedbackModel(fname, mail, desc, cont);
Call<String> feedbackcall = feedbackApi.sendfeedback(fname,mail,desc,cont);

feedbackcall.enqueue(new Callback<String>() {
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
            Toast.makeText(getContext(),response.body(),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getContext(),"fail",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();

    }
});

            }
        });
                return view;

    }




}
