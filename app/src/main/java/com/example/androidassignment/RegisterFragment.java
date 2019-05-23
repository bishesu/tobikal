package com.example.androidassignment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment  {
    private TextInputLayout textInputFirstname;
    private TextInputLayout textInputLastname;
    private TextInputLayout textInputUsername;
    private  TextInputLayout textInputPassword;
    private  TextInputLayout textInputConfirmpassword;
    Button register;
    public RegisterFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false);
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        textInputFirstname = rootView.findViewById(R.id.text_input_firstname);
        textInputLastname = rootView.findViewById(R.id.text_input_lastname);
        textInputUsername = rootView.findViewById(R.id.text_input_username);
        textInputPassword = rootView.findViewById(R.id.text_input_password);
        textInputConfirmpassword = rootView.findViewById(R.id.text_input_confirmpassowrd);
        register = rootView.findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatefirstname() | !validatelasttname() | !validateusername() | !validatepassword() | !validateconfirmpassword()){
                    return;
                }
            }
        });

        return rootView;
    }

    private boolean validatefirstname(){
        String fullnameinput = textInputFirstname.getEditText().getText().toString().toString().trim();
        if (fullnameinput.isEmpty()) {
            textInputFirstname.setError("Filed can't be empty");
            return false;
        }else{
                textInputFirstname.setError(null);
                return true;
            }
        }private boolean validatelasttname(){
        String fullnameinput = textInputLastname.getEditText().getText().toString().toString().trim();
        if (fullnameinput.isEmpty()) {
            textInputLastname.setError("Filed can't be empty");
            return false;
        }else{
                textInputLastname.setError(null);
                return true;
            }
        }
    private boolean validateusername(){
        String usernameinput = textInputUsername.getEditText().getText().toString().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsername.setError("Filed can't be empty");
            return false;
        }else{
            textInputUsername.setError(null);
            return true;
        }
    }
    private boolean validatepassword(){
        String passwordinput = textInputPassword.getEditText().getText().toString().toString().trim();
        if (passwordinput.isEmpty()) {
            textInputPassword.setError("Filed can't be empty");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
    private boolean validateconfirmpassword(){
        String confirmpasswordinput = textInputConfirmpassword.getEditText().getText().toString().toString().trim();
        if (confirmpasswordinput.isEmpty()) {
            textInputConfirmpassword.setError("Filed can't be empty");
            return false;
        }else{
            textInputConfirmpassword.setError(null);
            return true;
        }
    }


}
