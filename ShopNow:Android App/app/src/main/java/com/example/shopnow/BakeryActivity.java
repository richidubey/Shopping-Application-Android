package com.example.shopnow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;

import java.util.ArrayList;
import java.util.List;

public class BakeryActivity extends AppCompatActivity {

    private List<Categories> dummyItems;
    private CategoryAdapter mAdapter;

    Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        checkoutButton = (Button)findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BakeryActivity.this, SettingsActivity.class));
            }
        });

        dummyItems = new ArrayList<>();
        Bitmap bm;
        dummyItems.add(new Categories(null, "Breads", "Bisk Farm", "Rs. 45", "Buy 1"));
        dummyItems.add(new Categories(null, "Cookies", "Elite Foods", "Rs 60", "Buy 2"));
        dummyItems.add(new Categories(null, "Desserts", "Sam Enterprises", "Rs 90", "Buy 3"));
        dummyItems.add(new Categories(null, "Cheesecakes", "Prabhat Udyog", "Rs. 70", "Buy 4"));
        dummyItems.add(new Categories(null, "Pies", "Feroze Foods", "Rs. 90", "Buy 5"));
        dummyItems.add(new Categories(null, "Muffins", "Samay Foods", "Rs. 50", "Buy 6"));
        dummyItems.add(new Categories(null, "Pizza", "Bonn Food Industries", "Rs. 250", "Buy 7"));
        dummyItems.add(new Categories(null, "Tortilla", "Modern Foods", "Rs. 300", "Buy 8"));

        mAdapter = new CategoryAdapter(this, dummyItems);
        ListView bookListView = (ListView) findViewById(R.id.am_list);

        bookListView.setAdapter(mAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}