package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PassingIntentsExercise extends AppCompatActivity {

    TextView textViewTitle, textViewFullName, textViewGender, textViewBirthdate, textViewPhoneNumber,
            textViewEmailAddress, textViewFatherName, textViewMotherName, textViewAddress;
    EditText editTextFirstName, editTextLastName, editTextMiddleInitial, editTextBirthdate,
            editTextPhoneNumber, editTextEmailAddress, editTextFatherFirstName, editTextFatherLastName,
            editTextMotherFirstName, editTextMotherLastName, editTextStreetAddress, editTextCity,
            editTextStateProvince, editTextCountry, editTextZipCode;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonOthers;
    Button buttonClear, buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewGender = findViewById(R.id.textViewGender);
        textViewBirthdate = findViewById(R.id.textViewBirthdate);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewEmailAddress = findViewById(R.id.textViewEmailAddress);
        textViewFatherName = findViewById(R.id.textViewFatherName);
        textViewMotherName = findViewById(R.id.textViewMotherName);
        textViewAddress = findViewById(R.id.textViewAddress);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextMiddleInitial = findViewById(R.id.editTextMiddleInitial);
        editTextBirthdate = findViewById(R.id.editTextBirthdate);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextFatherFirstName = findViewById(R.id.editTextFatherFirstName);
        editTextFatherLastName = findViewById(R.id.editTextFatherLastName);
        editTextMotherFirstName = findViewById(R.id.editTextMotherFirstName);
        editTextMotherLastName = findViewById(R.id.editTextMotherLastName);
        editTextStreetAddress = findViewById(R.id.editTextStreetAddress);
        editTextCity = findViewById(R.id.editTextCity);
        editTextStateProvince = findViewById(R.id.editTextStateProvince);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextZipCode = findViewById(R.id.editTextZipCode);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonOthers = findViewById(R.id.radioButtonOthers);

        buttonClear = findViewById(R.id.buttonClear);
        buttonSubmit = findViewById(R.id.buttonSubmit);



        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }


    private void clearForm() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextMiddleInitial.setText("");
        editTextBirthdate.setText("");
        editTextPhoneNumber.setText("");
        editTextEmailAddress.setText("");
        editTextFatherFirstName.setText("");
        editTextFatherLastName.setText("");
        editTextMotherFirstName.setText("");
        editTextMotherLastName.setText("");
        editTextStreetAddress.setText("");
        editTextCity.setText("");
        editTextStateProvince.setText("");
        editTextCountry.setText("");
        editTextZipCode.setText("");
        radioGroupGender.clearCheck();
    }

    private void submitForm() {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String middleInitial = editTextMiddleInitial.getText().toString();

        String gender = "";
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedGenderId != -1) {
            RadioButton selectedGender = findViewById(selectedGenderId);
            gender = selectedGender.getText().toString();
        }

        String bDate = editTextBirthdate.getText().toString();
        String pNumber =  editTextPhoneNumber.getText().toString();
        String emailAdd = editTextEmailAddress.getText().toString();
        String fatherFirstName = editTextFatherFirstName.getText().toString();
        String fatherLastName = editTextFatherLastName.getText().toString();
        String motherFirstName = editTextMotherFirstName.getText().toString();
        String motherLastName = editTextMotherLastName.getText().toString();
        String streetAddress = editTextStreetAddress.getText().toString();
        String city = editTextCity.getText().toString();
        String stateProvince = editTextStateProvince.getText().toString();
        String country = editTextCountry.getText().toString();
        String zipCode = editTextZipCode.getText().toString();

        Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
        intent.putExtra("fname_key", firstName);
        intent.putExtra("lname_key", lastName);
        intent.putExtra("minitial_key", middleInitial);
        intent.putExtra("gender_key", gender);
        intent.putExtra("bdate_key", bDate);
        intent.putExtra("pnum_key", pNumber);
        intent.putExtra("eadd_key", emailAdd);
        intent.putExtra("father_fname_key", fatherFirstName);
        intent.putExtra("father_lname_key", fatherLastName);
        intent.putExtra("mother_fname_key", motherFirstName);
        intent.putExtra("mother_lname_key", motherLastName);
        intent.putExtra("street_address_key", streetAddress);
        intent.putExtra("city_key", city);
        intent.putExtra("state_province_key", stateProvince);
        intent.putExtra("country_key", country);
        intent.putExtra("zip_code_key", zipCode);

        startActivity(intent);


    }
}