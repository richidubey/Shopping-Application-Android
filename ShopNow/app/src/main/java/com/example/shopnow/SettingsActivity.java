package com.example.shopnow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    Button checkzoneButton, proceedButton;
    Set<String> redZone = new HashSet<>();
    Set<String> greenZone = new HashSet<>();

    String[] items = new String[]{"Tomorrow, 9:00AM-10:00AM", "Tomorrow, 10:30AM-11:30AM",
            "Tomorrow, 12:00PM-1:00PM", "Tomorrow, 3:00PM-4:00PM", "Tomorrow, 4:30PM-5:30PM",
            "Tomorrow, 6:00PM-7:00PM"};

    EditText adrs1, adrs2, city, state, pin;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        redZone.add("Hyderabad");
        redZone.add("Chennai");
        redZone.add("Bangalore");
        redZone.add("Mumbai");

        greenZone.add("Pilani");
        greenZone.add("Pondicherry");
        greenZone.add("Jaipur");

        checkzoneButton = findViewById(R.id.checkZone);
        proceedButton = findViewById(R.id.proceed);
        adrs1 = findViewById(R.id.address1EditText);
        adrs2 = findViewById(R.id.address2EditText);
        city = findViewById(R.id.cityEditText);
        state = findViewById(R.id.stateEditText);
        pin = findViewById(R.id.pincodeEditText);
        spin = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spin.setAdapter(adapter);

        checkzoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredCity = city.getText().toString();
                String enteredState = state.getText().toString();
                if(enteredCity.length()==0 || enteredState.length()==0){
                    Toast.makeText(getApplicationContext(), "Please enter city and state " +
                            "both", Toast.LENGTH_LONG).show();
                }else{
                    if(redZone.contains(enteredCity) || redZone.contains(enteredState)){
                        Toast.makeText(getApplicationContext(), "You are in red zone; Order " +
                                "time MWF   10:00AM to 1:00PM only", Toast.LENGTH_LONG).show();
                    }else if(greenZone.contains(enteredCity) || greenZone.contains(enteredState)){
                        Toast.makeText(getApplicationContext(), "You are in green zone; " +
                                "Select Time Slot", Toast.LENGTH_LONG).show();
                        spin.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Proceeding to Payment Page "
                        , Toast.LENGTH_LONG).show();
                startActivity(new Intent(SettingsActivity.this, PaymentActivity.class));
            }
        });
    }
}
