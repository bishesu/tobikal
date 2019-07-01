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

import com.example.androidassignment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextInputLayout textInputUsernamelogin;
    private  TextInputLayout textInputPasswordlogin;
    private TextView loginintent;
Button button;
    // Required empty public constructor
    public LoginFragment() {

    }


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
        String usernameinput = textInputUsernamelogin.getEditText().getText().toString().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsernamelogin.setError("Filed can't be empty");
            return false;
        }else{
            textInputUsernamelogin.setError(null);
            return true;
        }
    }
    private boolean validatepasswordlogin(){
        String passwordinput = textInputPasswordlogin.getEditText().getText().toString().toString().trim();
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
                if (!validateusernamelogin() | !validatepasswordlogin() ){

                    return;
                }
                break;

            case R.id.intenttv:

//                Intent intent=new Intent(getContext(),LoginRegister.class);
//                startActivity(intent);
                TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabId);
                tabs.getTabAt(1).select();


                break;
        }

    }
}
