package com.example.khowoatt.bakery;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.khowoatt.bakery.LoginRegister.Login;
import com.example.khowoatt.bakery.SQL.BakeryTable;
import com.example.khowoatt.bakery.SQL.CakeTable;
import com.example.khowoatt.bakery.SQL.DrinkTable;
import com.example.khowoatt.bakery.SQL.OrderTable;
import com.example.khowoatt.bakery.SQL.UserTable;
import com.example.khowoatt.bakery.menu.CakeMenu;
import com.example.khowoatt.bakery.menu.CookieMenu;
import com.example.khowoatt.bakery.menu.DrinksMenu;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private UserTable objUserTABLE;
    private BakeryTable objBakeryTABLE;
    private OrderTable objOrderTABLE;
    private CakeTable objCakeTABLE;
    private DrinkTable objDrinkTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        connectedSQLite();//เชื่อมต่อกับ SQLite

        //testAddValue();//ทดสอบ เพิ่มข้อมูลลง SQLite

        synJSONtoSQLite();

    }

    private void synJSONtoSQLite() {
        StrictMode.ThreadPolicy myPolicy = new StrictMode
                .ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTimes = 0;
        while (intTimes <= 1 ) {

            InputStream objInputStream = null;
            String strJSON = null;
            String strUserURL = "http://5711020660011.sci.dusit.ac.th/user.php";
            String strOrderURL = "http://5711020660011.sci.dusit.ac.th/order.php";
            String strBakeryURL = "http://5711020660011.sci.dusit.ac.th/bakery.php";
            String strCakeURL = "http://5711020660011.sci.dusit.ac.th/cake.php";
            String strDrinkURL = "http://5711020660011.sci.dusit.ac.th/drink.php";

            HttpPost objHttpPost;

            //Create InputStream
            try {
                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTimes) {
                    case 0:
                        objHttpPost = new HttpPost(strUserURL);
                        break;
                    case 1:
                    objHttpPost = new HttpPost(strOrderURL);
                        break;
                    case 2:
                    objHttpPost = new HttpPost(strBakeryURL);
                        break;
                    case 3:
                    objHttpPost = new HttpPost(strCakeURL);
                        break;
                    default:
                        objHttpPost = new HttpPost(strDrinkURL);
                        break;
                    //default:

                }
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();
            }catch (Exception e){
                Log.d("masterUNG","InputStream ==>"+e.toString());
            }

            //Create strJSON
            try {
                BufferedReader objBufferedReader = new BufferedReader
                        (new InputStreamReader(objInputStream, "UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine = null;
                while ((strLine = objBufferedReader.readLine()) != null) {
                    objStringBuilder.append(strLine);
                }
                objInputStream.close();
                strJSON = objStringBuilder.toString();
            } catch (Exception e) {
                Log.d("masterUNG","strJSON ==>"+e.toString());
            }

            //Update to SQLite

            intTimes += 1;
        }
    }//กำหนดให้แอพเชื่อมต่อ Http wfh

    public void onClickCake (View view){
        Intent intent = new Intent(MainActivity.this,CakeMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Cake

    public void onClickMenu (View view){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }//ลิ้งกลับหน้า login

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
        objDrinkTABLE.addNewDrink("testDrink","testSource","testPrice");
        objCakeTABLE.addNewCake("testCake","testSource","testPrice");
    }

    private void connectedSQLite(){
        objUserTABLE = new UserTable(this);
        objBakeryTABLE = new BakeryTable(this);
        objOrderTABLE = new OrderTable(this);
        objCakeTABLE = new CakeTable(this);
        objDrinkTABLE = new DrinkTable(this);
    }

}
