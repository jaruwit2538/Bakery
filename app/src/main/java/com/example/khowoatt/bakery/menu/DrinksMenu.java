package com.example.khowoatt.bakery.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.khowoatt.bakery.MainActivity;
import com.example.khowoatt.bakery.R;

public class DrinksMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);
    }
    public void onClickMain (View view){
        Intent intent = new Intent(DrinksMenu.this,MainActivity.class);
        startActivity(intent);
    }
}
