package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MapsExercise extends AppCompatActivity {

    ImageButton btnMap1, btnMap2, btnMap3, btnMap4, btnMap5;
    int[] imageResources = {R.drawable.kawasan, R.drawable.lambug, R.drawable.boracay, R.drawable.singapore, R.drawable.tokyo};
    boolean[] isImageClicked = {false, false, false, false, false};
    int clickedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        btnMap1 = findViewById(R.id.btnMap1);
        btnMap2 = findViewById(R.id.btnMap2);
        btnMap3 = findViewById(R.id.btnMap3);
        btnMap4 = findViewById(R.id.btnMap4);
        btnMap5 = findViewById(R.id.btnMap5);

        btnMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(0, btnMap1);
            }
        });

        btnMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(1, btnMap2);
            }
        });

        btnMap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(2, btnMap3);
            }
        });

        btnMap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(3, btnMap4);
            }
        });

        btnMap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(4, btnMap5);
            }
        });
    }

    private void handleClick(int index, ImageButton clickedButton) {
        resetImageButtonScales();

        enlargeImageButton(clickedButton);

        getWindow().setBackgroundDrawableResource(imageResources[index]);

        for (int i = 0; i < isImageClicked.length; i++) {
            if (i != index) {
                isImageClicked[i] = false;
            }
        }

        if (isImageClicked[index]) {
            openGoogleMaps(getCoordinates(index));
        }

        clickedIndex = index;
        isImageClicked[index] = true;
    }


    private void resetImageButtonScales() {
        btnMap1.setScaleX(1.0f);
        btnMap1.setScaleY(1.0f);
        btnMap2.setScaleX(1.0f);
        btnMap2.setScaleY(1.0f);
        btnMap3.setScaleX(1.0f);
        btnMap3.setScaleY(1.0f);
        btnMap4.setScaleX(1.0f);
        btnMap4.setScaleY(1.0f);
        btnMap5.setScaleX(1.0f);
        btnMap5.setScaleY(1.0f);


    }

    private void enlargeImageButton(ImageButton imageButton) {
        imageButton.setScaleX(1.2f);
        imageButton.setScaleY(1.2f);
    }

    private void openGoogleMaps(String coordinates) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + coordinates));
        startActivity(intent);
    }

    private String getCoordinates(int index) {
        switch (index) {
            case 0:
                return "9.803712133592084,123.37464263227865";
            case 1:
                return "9.853756913695578,123.3695125625712";
            case 2:
                return "11.952935157485378,121.92976067659173";
            case 3:
                return "1.2868199816202788,103.85439792488508";
            case 4:
                return "35.749838015913646,139.2073748218412";
            default:
                return "";
        }
    }
}
