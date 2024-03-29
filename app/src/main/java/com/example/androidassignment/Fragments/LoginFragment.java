package com.example.androidassignment.Fragments;


import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.example.androidassignment.notification.notification;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.SENSOR_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText textInputUsernamelogin;
    private NotificationManagerCompat notificationManagerCompat;
    private  EditText textInputPasswordlogin;
    private TextView loginintent;

    SharedPreferences preferences;
    SharedPreferences preferences1;
    SharedPreferences.Editor editor1;
    SharedPreferences.Editor editor;
    Boolean isloggedin=false;
Button button;
    String usernameinput;
    String passwordinput;

    SensorManager sensorManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        notificationManagerCompat = NotificationManagerCompat.from(getActivity());
        notification channel = new notification(getActivity());

        preferences1=getActivity().getSharedPreferences("User",0);
        editor1=preferences1.edit();
        channel.notification();
        textInputUsernamelogin = rootView.findViewById(R.id.usernamelogin);
        textInputPasswordlogin = rootView.findViewById(R.id.passwordlogin);
        button = rootView.findViewById(R.id.btnlogin);
        loginintent=rootView.findViewById(R.id.intenttv);
        loginintent.setOnClickListener(this);
        button.setOnClickListener(this);
        proximity();
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
                                    editor.putString("userId",token.getId());
//                                    editor.putBoolean("isloggedin",false);
                                    editor.commit();

                                    System.out.println("bises id: "+token.getId());
                                    Intent intent1=new Intent(getActivity(),MainActivity.class);
                                    isloggedin=true;
                                    editor1.putBoolean("isloggedin",isloggedin).commit();
                                    startActivity(intent1);
                                    DispalyNotification();
                                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();


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

    private void DispalyNotification() {
        Notification notification = new NotificationCompat.Builder(getActivity(), com.example.androidassignment.notification.notification.Channel_1)
                .setSmallIcon(R.drawable.ic_tap_and_play_black_24dp)
                .setContentTitle("Logged in Successfully")
                .setContentText("You have logged in successfully")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }

    public void proximity()
    {
        sensorManager=(SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null)
        {
            Toast.makeText(getActivity(), "No sensor detected", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(), "Sensor Kicking in .....", Toast.LENGTH_SHORT).show();
        }

        SensorEventListener proximityListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = 0;
                        getActivity().getWindow().setAttributes(params);
                    } else {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = -1f;
                        getActivity().getWindow().setAttributes(params);
                    }
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(proximityListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
    }
}
