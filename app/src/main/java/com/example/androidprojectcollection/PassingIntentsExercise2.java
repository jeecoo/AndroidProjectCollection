package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    TextView textViewFirstNameValue, textViewLastNameValue, textViewGenderValue,
            textViewBirthdateValue, textViewPhoneNumberValue, textViewEmailAddressValue,
            textViewFatherNameValue, textViewMotherNameValue, textViewAddressValue;
    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        textViewFirstNameValue = findViewById(R.id.textViewFirstNameValue);
        textViewLastNameValue = findViewById(R.id.textViewLastNameValue);
        textViewGenderValue = findViewById(R.id.textViewGenderValue);
        textViewBirthdateValue = findViewById(R.id.textViewBirthdateValue);
        textViewPhoneNumberValue = findViewById(R.id.textViewPhoneNumberValue);
        textViewEmailAddressValue = findViewById(R.id.textViewEmailAddressValue);
        textViewFatherNameValue = findViewById(R.id.textViewFatherNameValue);
        textViewMotherNameValue = findViewById(R.id.textViewMotherNameValue);
        textViewAddressValue = findViewById(R.id.textViewAddressValue);

        Intent intent = getIntent();
        textViewFirstNameValue.setText(intent.getStringExtra("fname_key"));
        textViewLastNameValue.setText(intent.getStringExtra("lname_key"));
        textViewGenderValue.setText(intent.getStringExtra("gender_key"));
        textViewBirthdateValue.setText(intent.getStringExtra("bdate_key"));
        textViewPhoneNumberValue.setText(intent.getStringExtra("pnum_key"));
        textViewEmailAddressValue.setText(intent.getStringExtra("eadd_key"));
        textViewFatherNameValue.setText(intent.getStringExtra("father_fname_key") + ", " + intent.getStringExtra("father_lname_key"));
        textViewMotherNameValue.setText(intent.getStringExtra("mother_fname_key") + ", " + intent.getStringExtra("mother_lname_key"));
        textViewAddressValue.setText(intent.getStringExtra("street_address_key") + ", " + intent.getStringExtra("city_key")
                                    + intent.getStringExtra("state_province_key")+ ", "
                                    + intent.getStringExtra("country_key") + ", "
                                    + intent.getStringExtra("zip_code_key"));

        buttonReturn = (Button) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }
}