package com.example.khowoatt.bakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CookieMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_menu);
    }
    public void onClickMain (View view){
        Intent intent = new Intent(CookieMenu.this,MainActivity.class);
        startActivity(intent);
    }
}
