package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ColorMatchingActivity extends AppCompatActivity {

    final int[] COLORSET = {Color.RED, Color.GREEN, Color.BLUE};
    public static boolean enabled = true;
    int[][] tiles = new int[][]{{0,0,0}, {0,0,0},{0,0,0}};
    Button[][] btns;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matching);
        btns = new Button[][]{
                {findViewById(R.id.button11), findViewById(R.id.button12), findViewById(R.id.button13)},
                {findViewById(R.id.button21), findViewById(R.id.button22), findViewById(R.id.button23)},
                {findViewById(R.id.button31), findViewById(R.id.button32), findViewById(R.id.button33)}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i, col = j;
                btns[row][col].setOnClickListener(new View.OnClickListener() {
                    final int r = row;
                    final int c = col;

                    @Override
                    public void onClick (View view){
                        if (enabled)
                            clickButton(r, c);
                    }
                });
            }
        }
        btnReset = findViewById(R.id.btnReturn);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomizeTiles();
                updateColors();
                enabled = true;

            }
        });

//        btnToWin = findViewById(R.id.btnWin);
//        btnToWin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toWin();
//                enabled = true;
//            }
//        });

        randomizeTiles();
        updateColors();
    }
    private void clickButton ( int row, int col){
        //changeTileValue(row, col);
        changeTileValue(row - 1, col);
        changeTileValue(row + 1, col);
        changeTileValue(row, col - 1);
        changeTileValue(row, col + 1);
        updateColors();

        if (allSameTiles()) {
            enabled = false;
//                Toast.makeText(getApplicationContext(), "YOU WIN!", Toast.LENGTH_SHORT.show());
        }

    }

    private void changeTileValue(int row, int col){
        if(row<0 || row > 2 || col < 0 || col > 2){
            return;
        }

        tiles[row][col] = (tiles[row][col] + 1) % 3;

    }

    private void updateColors(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                int tileValue = tiles[row][col];
                int color = COLORSET[tileValue];
                btns[row][col].setBackgroundColor(color);
            }
        }
    }

    private boolean allSameTiles() {
        int val = tiles[0][0];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (tiles[row][col] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    private void randomizeTiles(){
        Random random = new Random();
        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col] = random.nextInt(3);
            }
        }
    }

    private void toWin(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                btns[row][col].setBackgroundColor(Color.RED);
            }
        }
    }


}