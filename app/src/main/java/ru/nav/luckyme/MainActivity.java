package ru.nav.luckyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView balance, result, comment;
    Button start;
    EditText bet;
    int myIntBalance = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bet = (EditText) findViewById(R.id.bet);
        start = (Button) findViewById(R.id.enter);
        balance = (TextView) findViewById(R.id.balance);
        result = (TextView) findViewById(R.id.result);
        comment = (TextView) findViewById(R.id.comment);

        View.OnClickListener startClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myBet = bet.getText().toString();
                int myIntBet = Integer.parseInt(myBet);
                if (myIntBet<=myIntBalance){
                    if (myIntBet>0){
                        String answer="";
                        int x1 = (int) (Math.random()*3)+1;
                        int x2 = (int) (Math.random()*3)+1;
                        int x3 = (int) (Math.random()*3)+1;

                        switch (x1){
                            case 1: answer=answer+"A "; break;
                            case 2: answer=answer+"B "; break;
                            case 3: answer=answer+"C "; break;
                        }
                        switch (x2){
                            case 1: answer=answer+"A "; break;
                            case 2: answer=answer+"B "; break;
                            case 3: answer=answer+"C "; break;
                        }
                        switch (x3){
                            case 1: answer=answer+"A "; break;
                            case 2: answer=answer+"B "; break;
                            case 3: answer=answer+"C "; break;
                        }

                        if(x1==x2 && x2==x3){
                            myIntBet=myIntBet*10;
                            comment.setText("Congratulations! You win "+myIntBet+"$!");
                            result.setText(answer);
                            myIntBalance=myIntBalance+myIntBet;
                            balance.setText("Your balance: "+myIntBalance+"$");
                        }else{
                            myIntBalance=myIntBalance-myIntBet;
                            if(myIntBalance<=0){
                                comment.setText("You lose and became a bankrupt.");
                            }else{
                                comment.setText("You lose.");
                            }
                            result.setText(answer);
                            balance.setText("Your balance: "+myIntBalance+"$");
                        }

                    }else{
                        comment.setText("Your bet must be more than 0$");
                        result.setText("* * *");
                    }

                }else{
                    comment.setText("You don't have so much money!");
                    result.setText("* * *");
                }
            }
        };

        start.setOnClickListener(startClick);
    }

}