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

import java.util.ArrayList;
import java.util.List;

public class VegetableActivity extends AppCompatActivity {

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
                startActivity(new Intent(VegetableActivity.this, SettingsActivity.class));
            }
        });

        dummyItems = new ArrayList<>();
        Bitmap bm;
        dummyItems.add(new Categories(null, "Spinach", "Text 1", "section 1", "Buy 1"));
        dummyItems.add(new Categories(null, "Carrot", "Text 2", "section 2", "Buy 2"));
        dummyItems.add(new Categories(null, "Broccoli", "Text 3", "section 3", "Buy 3"));
        dummyItems.add(new Categories(null, "Garlic", "Text 4", "section 4", "Buy 4"));
        dummyItems.add(new Categories(null, "Green Peas", "Text 5", "section 5", "Buy 5"));
        dummyItems.add(new Categories(null, "Red Cabbage", "Text 6", "section 6", "Buy 6"));
        dummyItems.add(new Categories(null, "Sweet Potatoes", "Text 7", "section 7", "Buy 7"));
        dummyItems.add(new Categories(null, "Tomato", "Text 8", "section 8", "Buy 8"));

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