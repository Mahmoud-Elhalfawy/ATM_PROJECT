package com.example.android.atm_project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.android.atm_project.R.color.colorPrimaryDark;

public class MainActivity extends AppCompatActivity {
    int counter1=0;
    int counter2=0;
    private TextView showText;
    private EditText cardNumber;
    private Button enterButton;
    private TextView nameText;
    private Button deposit;
    private Button withdraw;
    private Button inquiry;
    private Button next;
    private Button previous;
    final BankAccount useraccount=new BankAccount();
    Client client=new Client("Mahmoud Ibrahim Elhalfawy",useraccount);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final Intent j=new Intent(MainActivity.this,Transaction3.class);
        final Intent i=new Intent(MainActivity.this,Transaction1.class);
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        cardNumber=(EditText)findViewById(R.id.bankNumber);
        enterButton=(Button)findViewById(R.id.enterButton);
        nameText=(TextView)findViewById(R.id.enterText);
        deposit=(Button)findViewById(R.id.deposit);
        withdraw=(Button)findViewById(R.id.withdraw);
        inquiry=(Button)findViewById(R.id.inquiry);
        next=(Button)findViewById(R.id.next);
        previous=(Button)findViewById(R.id.previous);
        showText=(TextView)findViewById(R.id.showText);
        useraccount.setBalance(0);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardNumber.getText().toString().equals("5391")){
                    useraccount.setNumber(cardNumber.getText().toString());
                    nameText.setTextColor(-16777216);
                    nameText.setText("Mahmoud Ibrahim Elhalfawy");
                    deposit.setVisibility(View.VISIBLE);
                    withdraw.setVisibility(View.VISIBLE);
                    inquiry.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    previous.setVisibility(View.VISIBLE);
                }
                else {
                    nameText.setText("please enter a valid card number");
                    nameText.setTextColor(Color.RED);
                }
            }
        });
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText.setText("Balance = "+ (Double.toString(client.checkBalance())));

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter1>0) {
                    showText.setText(String.valueOf(client.checkHistory(--counter1)));
                }else
                    Toast.makeText(MainActivity.this,"No Previous Transactions ",Toast.LENGTH_LONG).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter1<5 && counter1<((client.userAccount.getHistory().size())-1) ){
                    showText.setText(String.valueOf(client.checkHistory(++counter1)));
                }else
                    Toast.makeText(MainActivity.this,"No Further Transactions",Toast.LENGTH_LONG).show();
            }
        });
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2=1;
                i.putExtra("balance",client.userAccount.getBalance());
                startActivityForResult(i,1);

            }
        });
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2=1;
                j.putExtra("oldBalance",client.userAccount.getBalance());
                startActivityForResult(j,2);
            }
        });

    }
   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1) {
            Double newDeposit=data.getDoubleExtra("newDeposit",0);
            if (newDeposit>0) {
                client.userAccount.add_history(newDeposit, "Deposit");
                client.deposit(newDeposit);
                counter1++;
            }else
                Toast.makeText(this, "No transaction made", Toast.LENGTH_LONG).show();
        }
        if(requestCode==2) {
            Double newWithdraw = data.getDoubleExtra("withdraw", 0);
            if(newWithdraw>0) {
                client.userAccount.add_history(newWithdraw, "Withdraw");
                client.withdraw(newWithdraw);
                counter1++;
            }else
                Toast.makeText(this, "No transaction made", Toast.LENGTH_LONG).show();



        }

        }


}
