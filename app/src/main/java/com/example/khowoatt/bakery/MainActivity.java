package com.example.khowoatt.bakery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.khowoatt.bakery.SQL.BakeryTable;
import com.example.khowoatt.bakery.SQL.OrderTable;
import com.example.khowoatt.bakery.SQL.UserTable;
import com.example.khowoatt.bakery.menu.CakeMenu;
import com.example.khowoatt.bakery.menu.CookieMenu;
import com.example.khowoatt.bakery.menu.DrinksMenu;

public class MainActivity extends AppCompatActivity {
    private UserTable objUserTABLE;
    private BakeryTable objBakeryTABLE;
    private OrderTable objOrderTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        connectedSQLite();//เชื่อมต่อกับ SQLite

        testAddValue();//ทดสอบ เพิ่มข้อมูลลง SQLite

    }
    public void onClickCake (View view){
        Intent intent = new Intent(MainActivity.this,CakeMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Cake

    public void onClickCookie (View view){
        Intent intent= new Intent(MainActivity.this,CookieMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Cookie

    public void onClickDrinks (View view){
        Intent intent = new Intent(MainActivity.this,DrinksMenu.class);
        startActivity(intent);
    }//ลิ้งหน้าไปหน้า Menu Drinks

    public void testAddValue(){
        objUserTABLE.addNewUser("testUser","testPass","testName","testPhone","testAddress");
        objBakeryTABLE.addNewBakery("testBakery","testSource","testPrice");
        objOrderTABLE.addNewOrder("testOfficer","testBakery","testDate","testTotalPrice");

    }

    private void connectedSQLite(){
        objUserTABLE = new UserTable(this);
        objBakeryTABLE = new BakeryTable(this);
        objOrderTABLE = new OrderTable(this);
    }

}
