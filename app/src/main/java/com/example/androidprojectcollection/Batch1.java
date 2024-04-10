package com.example.androidprojectcollection;

import static com.example.androidprojectcollection.R.id.currentPlayerText;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Batch1 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];
    private boolean player1Turn = true;
    private TextView currentPlayerText;
    private TextView winText;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch1);

        currentPlayerText = findViewById(R.id.currentPlayerText);
        winText = findViewById(R.id.winText);
        btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        // Initialize buttons
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button" + (i * 5 + j + 1);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        resetGame();
    }

    @Override
    public void onClick(View v) {

        if (!winText.getText().toString().isEmpty()) {
            return;
        }

        int colIndex = -1;
        for (int j = 0; j < 5; j++) {
            if (v == buttons[0][j]) {
                colIndex = j;
                break;
            }
        }
        // If the clicked button is not in the top row of any column, return
        if (colIndex == -1) {
            return;
        }

        int rowIndex = 4;
        while (rowIndex >= 0 && !buttons[rowIndex][colIndex].getText().toString().isEmpty()) {
            rowIndex--;
        }

        if (rowIndex < 0) {
            return;
        }
        // Set the text and color based on the current player
        if (player1Turn) {
            buttons[rowIndex][colIndex].setText("♔");
            buttons[rowIndex][colIndex].setBackgroundColor(Color.RED);
            currentPlayerText.setText("Player 2's Turn");
            currentPlayerText.setTextColor(Color.BLUE);
        } else {
            buttons[rowIndex][colIndex].setText("♕");
            buttons[rowIndex][colIndex].setBackgroundColor(Color.BLUE);
            currentPlayerText.setText("Player 1's Turn");
            currentPlayerText.setTextColor(Color.RED);
        }
        // Check for win condition and update player turn
        if (checkForWin()) {
            if (player1Turn) {
                winText.setText("Player 1 Wins!");
                winText.setTextColor(Color.RED);
            } else {
                winText.setText("Player 2 Wins!");
                winText.setTextColor(Color.BLUE);
            }
        } else {
            player1Turn = !player1Turn;
        }
    }


    private boolean checkForWin() {
        String[][] field = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Check rows
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals(field[i][j + 1]) && field[i][j].equals(field[i][j + 2]) && !field[i][j].equals("")) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (field[i][j].equals(field[i + 1][j]) && field[i][j].equals(field[i + 2][j]) && !field[i][j].equals("")) {
                    return true;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals(field[i + 1][j + 1]) && field[i][j].equals(field[i + 2][j + 2]) && !field[i][j].equals("")) {
                    return true;
                }
                if (field[i][j + 2].equals(field[i + 1][j + 1]) && field[i][j + 2].equals(field[i + 2][j]) && !field[i][j + 2].equals("")) {
                    return true;
                }
            }
        }

        return false;
    }

    private void resetGame() {
        // Reset buttons
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBackgroundColor(Color.WHITE);
            }
        }

        currentPlayerText.setText("Player 1's Turn");
        currentPlayerText.setTextColor(Color.RED);
        winText.setText("");
        player1Turn = true;
    }
}