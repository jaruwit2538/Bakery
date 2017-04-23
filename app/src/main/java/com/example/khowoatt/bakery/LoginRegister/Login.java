package com.example.khowoatt.bakery.LoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.khowoatt.bakery.MainActivity;
import com.example.khowoatt.bakery.OpenApp;
import com.example.khowoatt.bakery.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void onClickMenu(View view){
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

}
