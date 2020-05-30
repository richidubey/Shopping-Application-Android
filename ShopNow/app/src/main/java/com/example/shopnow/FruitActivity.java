package com.example.shopnow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {

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
                startActivity(new Intent(FruitActivity.this, SettingsActivity.class));
            }
        });

        dummyItems = new ArrayList<>();
        Bitmap bm ;
        dummyItems.add(new Categories(null, "Item 1", "Text 1", "section 1", "Buy 1"));
        dummyItems.add(new Categories(null, "Item 2", "Text 2", "section 2", "Buy 2"));
        dummyItems.add(new Categories(null, "Item 3", "Text 3", "section 3", "Buy 3"));
        dummyItems.add(new Categories(null, "Item 4", "Text 4", "section 4", "Buy 4"));
        dummyItems.add(new Categories(null, "Item 5", "Text 5", "section 5", "Buy 5"));
        dummyItems.add(new Categories(null, "Item 6", "Text 6", "section 6", "Buy 6"));
        dummyItems.add(new Categories(null, "Item 7", "Text 7", "section 7", "Buy 7"));
        dummyItems.add(new Categories(null, "Item 8", "Text 8", "section 8", "Buy 8"));

        mAdapter = new CategoryAdapter(this, dummyItems);
        ListView bookListView = (ListView) findViewById(R.id.am_list);

        bookListView.setAdapter(mAdapter);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
//                new IntentFilter("custom-message"));

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
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String ItemName = intent.getStringExtra("item");
            String qty = intent.getStringExtra("quantity");
            Toast.makeText(FruitActivity.this,ItemName +" "+qty ,Toast.LENGTH_SHORT).show();
        }
    };
}
