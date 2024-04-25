package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;
    int currentColorIndex = 0;
    int typefaceIndex = 0;
    int currentShapeIndex = 0;
    int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
    int[] newStyle = {Typeface.BOLD, Typeface.ITALIC, Typeface.NORMAL,};
    private int shapeDrawableId;
    private int[] shapes = {R.drawable.shape_default, R.drawable.shape_square};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
        btnChanger.setBackgroundColor(Color.WHITE);
        btnChanger.setTextColor(Color.BLACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return true;
    }

    private void changeTextStyle() {
        btnChanger.setTypeface(Typeface.defaultFromStyle(newStyle[typefaceIndex]));
        typefaceIndex++;
        if (typefaceIndex >= newStyle.length) {
            typefaceIndex = 0;
        }

    }

    private void changeColor() {
        btnChanger.setBackgroundColor(colors[currentColorIndex]);
        currentColorIndex++;
        if (currentColorIndex >= colors.length) {
            currentColorIndex = 0;
        }
    }

    private void changeTextColor() {
        btnChanger.setTextColor(colors[currentColorIndex]);
        currentColorIndex++;
        if (currentColorIndex >= colors.length) {
            currentColorIndex = 0;
        }
    }

    private void changeShape(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId >= 0 && itemId < shapes.length) {
            shapeDrawableId = shapes[itemId];
        }
        Drawable backgroundDrawable = btnChanger.getBackground();

        int currentColor;
        if (backgroundDrawable instanceof ColorDrawable) {
            currentColor = ((ColorDrawable) backgroundDrawable).getColor();
        } else {
            currentColor = Color.WHITE;
        }
        int currentFontStyle = btnChanger.getTypeface().getStyle();

        btnChanger.setBackgroundResource(shapeDrawableId);
        btnChanger.setBackgroundColor(currentColor);
        btnChanger.setTypeface(Typeface.defaultFromStyle(currentFontStyle));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.mItemChangeColor:
                changeColor();
                Toast.makeText(this, "Shape Color is changed", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mItemChangeTextStyle:
                changeTextStyle();
                Toast.makeText(this, "Text Style is changed", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mItemChangeTextColor:
                changeTextColor();
                Toast.makeText(this, "Text Color is changed", Toast.LENGTH_SHORT).show();
                return true;
//            case R.id.mItemChangeShape:
//                changeShape(item);
//                return true;
            case R.id.mItemChangeSize:

                return true;
            case R.id.mItemReset:
                resetButton();
                return true;
            case R.id.mItemExit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void resetButton() {
        btnChanger.setBackgroundColor(Color.WHITE);
        //btnChanger.setBackgroundResource(shapes[0]);
        btnChanger.setTextColor(Color.BLACK);
        btnChanger.setTypeface(Typeface.DEFAULT);
    }

}