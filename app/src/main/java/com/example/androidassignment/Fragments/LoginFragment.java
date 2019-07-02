package com.example.androidassignment.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidassignment.APIs.LoginRegisterApi;
import com.example.androidassignment.LoginRegister;
import com.example.androidassignment.MainActivity;
import com.example.androidassignment.Model.UserModel;
import com.example.androidassignment.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextInputLayout textInputUsernamelogin;
    private  TextInputLayout textInputPasswordlogin;
    private TextView loginintent;
Button button;
    String usernameinput;
    String passwordinput;
    LoginRegisterApi apii;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        textInputUsernamelogin = rootView.findViewById(R.id.text_input_username_login);
        textInputPasswordlogin = rootView.findViewById(R.id.text_input_password_login);
        button = rootView.findViewById(R.id.btnlogin);
        loginintent=rootView.findViewById(R.id.intenttv);
        loginintent.setOnClickListener(this);
        button.setOnClickListener(this);
        return rootView;
    }
    private boolean validateusernamelogin(){
         usernameinput = textInputUsernamelogin.getEditText().getText().toString().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsernamelogin.setError("Filed can't be empty");
            return false;
        }else{
            textInputUsernamelogin.setError(null);
            return true;
        }
    }
    private boolean validatepasswordlogin(){
         passwordinput = textInputPasswordlogin.getEditText().getText().toString().toString().trim();
        if (passwordinput.isEmpty()) {
            textInputPasswordlogin.setError("Filed can't be empty");
            return false;
        }else{
            textInputPasswordlogin.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin:
                if (validateusernamelogin() && validatepasswordlogin() ){
                    System.out.println("bises:"+usernameinput+" pw: "+passwordinput);

                    Intent intent=new Intent(getContext(), MainActivity.class);
                            startActivity(intent);

//                    Call<UserModel> call=apii.getUser(usernameinput,passwordinput);
//                    call.enqueue(new Callback<UserModel>() {
//                        @Override
//                        public void onResponse(Call<UserModel> call, Response<UserModel> response) {
//                            if (!response.isSuccessful()){
//                                Toast.makeText(getContext(), "Code: "+response.code(), Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                            System.out.println("bishes: "+response.body().getEmail());
//                            Intent intent=new Intent(getContext(), MainActivity.class);
//                            startActivity(intent);
//                        }
//
//                        @Override
//                        public void onFailure(Call<UserModel> call, Throwable t) {
//                            System.out.println("eee"+t.getMessage());
//                        }
//                    });
                }
                break;

            case R.id.intenttv:

//                Intent intent=new Intent(getContext(),LoginRegisterApi.class);
//                startActivity(intent);
                TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabId);
                tabs.getTabAt(1).select();


                break;
        }

    }
}
