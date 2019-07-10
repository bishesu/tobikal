package com.example.androidassignment.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidassignment.APIs.LoginRegisterApi;
import com.example.androidassignment.MainActivity;
import com.example.androidassignment.Model.RegestrationModel;
import com.example.androidassignment.R;
import com.example.androidassignment.Retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private TextInputEditText textInputFirstname;
    private TextInputEditText textInputLastname;
    private TextInputEditText textInputUsername;
    private  TextInputEditText textInputPassword;
    private  TextInputEditText textInputEmail;
    Button register;

    public RegisterFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false);
        final View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        textInputFirstname = rootView.findViewById(R.id.firstnameregister);
        textInputLastname = rootView.findViewById(R.id.lastnameregister);
        textInputUsername = rootView.findViewById(R.id.usernameregister);
        textInputPassword = rootView.findViewById(R.id.passwordregister);
        textInputEmail = rootView.findViewById(R.id.emailregister);
        register = rootView.findViewById(R.id.btnregister);




        register.setOnClickListener(this);

        return rootView;
    }


    private boolean validatefirstname(){
        String fullnameinput = textInputFirstname.getText().toString().toString().trim();
        if (fullnameinput.isEmpty()) {
            textInputFirstname.setError("Filed can't be empty");
            return false;
        }else{
                textInputFirstname.setError(null);
                return true;
            }
        }private boolean validatelasttname(){
        String fullnameinput = textInputLastname.getText().toString().toString().trim();
        if (fullnameinput.isEmpty()) {
            textInputLastname.setError("Filed can't be empty");
            return false;
        }else{
                textInputLastname.setError(null);
                return true;
            }
        }
    private boolean validateusername(){
        String usernameinput = textInputUsername.getText().toString().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsername.setError("Filed can't be empty");
            return false;
        }else{
            textInputUsername.setError(null);
            return true;
        }
    }
    private boolean validatepassword(){
        String passwordinput = textInputPassword.getText().toString().toString().trim();
        if (passwordinput.isEmpty()) {
            textInputPassword.setError("Filed can't be empty");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
    private boolean validateemail(){
        String emailinput = textInputEmail.getText().toString().toString().trim();
        if (emailinput.isEmpty()) {
            textInputEmail.setError("Filed can't be empty");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnregister:

                String fname = textInputFirstname.getText().toString();
                String lname = textInputLastname.getText().toString();
                String email = textInputEmail.getText().toString();
                String username = textInputUsername.getText().toString();
                String password = textInputPassword.getText().toString();

                RegestrationModel model = new RegestrationModel();
            LoginRegisterApi loginRegister = RetrofitHelper.instance().create(LoginRegisterApi.class);

            Call<String> call = loginRegister.addUser(fname,lname,email,username,password);

                //System.out.println("bises: "+regestrationModel.getFirstname());
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    System.out.println("bises: "+response.body());
                    Vibrator   vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(2000);
                    Toast.makeText(getActivity(), "registered successfully", LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getActivity(), "not registered", LENGTH_SHORT).show();

                }
            });


//        }
//                Intent intent= new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);

        break;
    }
    }
}
