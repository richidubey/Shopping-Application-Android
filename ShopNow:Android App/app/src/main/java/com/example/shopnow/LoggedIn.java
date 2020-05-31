package com.example.shopnow;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class LoggedIn extends AppCompatActivity {

    private static final int NEWS_LOADER_ID = 1;
    private static final String NEWS_APP_URL = "https://content.guardianapis.com/search";
    private ItemAdapter mAdapter;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    List<Items> dummyItems;

    //Bitmap bitmapFruit = BitmapFactory.decodeFile(R.drawable."im_bakery");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        dummyItems = new ArrayList<>();
        Bitmap bm ;
        dummyItems.add(new Items(null, "Fruits"));
        dummyItems.add(new Items(null, "Vegetable"));
        dummyItems.add(new Items(null, "Bakery"));

        mAdapter = new ItemAdapter(this, dummyItems);
        ListView bookListView = (ListView) findViewById(R.id.am_list);

        bookListView.setAdapter(mAdapter);
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(LoggedIn.this, FruitActivity.class));
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(LoggedIn.this, VegetableActivity.class));
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(LoggedIn.this, BakeryActivity.class));
                        break;
                }
            }
        });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}