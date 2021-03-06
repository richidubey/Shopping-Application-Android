package com.example.shopnow;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
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


public class HomeActivity extends AppCompatActivity {

    private ItemAdapter mAdapter;


    List<Items> dummyItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dummyItems = new ArrayList<>();
        Bitmap bm ;
        dummyItems.add(new Items(null, "Item 1", "Text 1", "section 1", "Buy 1"));
        dummyItems.add(new Items(null, "Item 2", "Text 2", "section 2", "Buy 2"));
        dummyItems.add(new Items(null, "Item 3", "Text 3", "section 3", "Buy 3"));
        dummyItems.add(new Items(null, "Item 4", "Text 4", "section 4", "Buy 4"));
        dummyItems.add(new Items(null, "Item 5", "Text 5", "section 5", "Buy 5"));
        dummyItems.add(new Items(null, "Item 6", "Text 6", "section 6", "Buy 6"));
        dummyItems.add(new Items(null, "Item 7", "Text 7", "section 7", "Buy 7"));
        dummyItems.add(new Items(null, "Item 8", "Text 8", "section 8", "Buy 8"));

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
                        startActivity(new Intent(HomeActivity.this, FruitActivity.class));
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(HomeActivity.this, VegetableActivity.class));
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(HomeActivity.this, BakeryActivity.class));
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(HomeActivity.this, FruitActivity.class));
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(HomeActivity.this, VegetableActivity.class));
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        startActivity(new Intent(HomeActivity.this, BakeryActivity.class));
                        break;
                }
            }
        });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        
    }
}