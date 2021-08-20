package ru.nav.luckyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity extends AppCompatActivity {
    TextView balance, result, comment;
    Button start, restart;
    EditText bet;
    int myIntBalance = 10000;
    String[] answerChars = {"A", "B", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bet = findViewById(R.id.bet);
        start = findViewById(R.id.enter);
        balance = findViewById(R.id.balance);
        result = findViewById(R.id.result);
        comment = findViewById(R.id.comment);
        restart = findViewById(R.id.restart);

        View.OnClickListener startClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myBet = bet.getText().toString();
                int myIntBet = Integer.parseInt(myBet);
                if (myIntBet <= myIntBalance) {
                    if (myIntBet > 0) {
                        String answer;
                        int x1 = (int)(Math.random() * 3);
                        int x2 = (int)(Math.random() * 3);
                        int x3 = (int)(Math.random() * 3);

                        answer = answerChars[x1] + " " + answerChars[x2] + " " + answerChars[x3];

                        if ((x1 == x2) && (x2 == x3)) {
                            myIntBet = myIntBet * 5;
                            comment.setText("Congratulations! You win " + myIntBet + "$!");
                            myIntBalance = myIntBalance + myIntBet;
                        } else {
                            myIntBalance = myIntBalance - myIntBet;
                            if (myIntBalance <= 0)
                                comment.setText("You lose and became a bankrupt.");
                            else
                                comment.setText("You lose.");
                        }
                        result.setText(answer);
                        balance.setText("Your balance: " + myIntBalance + "$");
                    } else {
                        comment.setText("Your bet must be more than 0$");
                        result.setText("* * *");
                    }
                } else {
                    comment.setText("You don't have so much money!");
                    result.setText("* * *");
                }
            }
        };

        View.OnClickListener restartClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntBalance = 10000;
                result.setText("* * *");
                comment.setText("");
                balance.setText("Your balance: " + myIntBalance + "$");
                bet.setText("");
            }
        };

        restart.setOnClickListener(restartClick);

        start.setOnClickListener(startClick);
    }
}