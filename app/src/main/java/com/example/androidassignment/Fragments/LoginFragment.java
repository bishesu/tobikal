package com.example.androidassignment.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidassignment.APIs.LoginRegisterApi;
import com.example.androidassignment.LoginRegister;
import com.example.androidassignment.MainActivity;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.Model.UserModel;
import com.example.androidassignment.R;
import com.example.androidassignment.Retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText textInputUsernamelogin;
    private  EditText textInputPasswordlogin;
    private TextView loginintent;
Button button;
    String usernameinput;
    String passwordinput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        textInputUsernamelogin = rootView.findViewById(R.id.usernamelogin);
        textInputPasswordlogin = rootView.findViewById(R.id.passwordlogin);
        button = rootView.findViewById(R.id.btnlogin);
        loginintent=rootView.findViewById(R.id.intenttv);
        loginintent.setOnClickListener(this);
        button.setOnClickListener(this);
        return rootView;
    }
    private boolean validateusernamelogin(){
         usernameinput = textInputUsernamelogin.getText().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsernamelogin.setError("Filed can't be empty");
            return false;
        }else{
            textInputUsernamelogin.setError(null);
            return true;
        }
    }
    private boolean validatepasswordlogin(){
         passwordinput = textInputPasswordlogin.getText().toString().trim();
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
//
                            String username=textInputUsernamelogin.getText().toString();
                            String password=textInputPasswordlogin.getText().toString();
                            LoginRegisterApi loginRegister= RetrofitHelper.instance().create(LoginRegisterApi.class);
                            Call<Token> tokenCall= loginRegister.getUser(username,password);

                            tokenCall.enqueue(new Callback<Token>() {
                                @Override
                                public void onResponse(Call<Token> call, Response<Token> response) {
                                    Token token=response.body();

                                    SharedPreferences preferences=getActivity().getSharedPreferences("tokenstore",0);
                                    SharedPreferences.Editor editor= preferences.edit();
                                    editor.putString("token",token.getToken());
                                    editor.commit();
                                    Intent intent1=new Intent(getActivity(),MainActivity.class);
                                    startActivity(intent1);

                                }

                                @Override
                                public void onFailure(Call<Token> call, Throwable t) {
                                    Toast.makeText(getActivity(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });

//
                }
                break;

            case R.id.intenttv:

//
                TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabId);
                tabs.getTabAt(1).select();


                break;
        }

    }
}
