package com.example.android.atm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Transaction3 extends AppCompatActivity {
    private TextView request_text;
    private EditText withdraw_text;
    private Button enterButton;
    private Button   exitButton;
    private double  withdraw;
    Intent j=new Intent();
    private double oldBalance;
    private double newWithdraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction3);
        Intent y=getIntent();
        request_text=(TextView)findViewById(R.id.request_text);
        request_text.setTextColor(-16777216);
        withdraw_text=(EditText)findViewById(R.id.withdraw_text);
        enterButton=(Button)findViewById(R.id.enter_button);
        exitButton=(Button)findViewById(R.id.exit_button);
        oldBalance=y.getDoubleExtra("oldBalance",0);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (withdraw_text.getText().toString().equals(""))
                    Toast.makeText(Transaction3.this, "No Money entered", Toast.LENGTH_LONG).show();
                else {
                    newWithdraw=Double.parseDouble(withdraw_text.getText().toString());
                    if (newWithdraw > oldBalance) {
                        Toast.makeText(Transaction3.this, "Not enough balance", Toast.LENGTH_SHORT).show();
                        newWithdraw = 0;
                    } else
                        Toast.makeText(Transaction3.this, "Successful Withdraw", Toast.LENGTH_SHORT).show();
                }
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j.putExtra("withdraw",newWithdraw);
                setResult(RESULT_OK,j);
                finish();
            }
        });

    }
}
