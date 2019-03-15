package com.example.android.atm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction1 extends AppCompatActivity {
private TextView requestText;
private EditText transText;
private Button transButton;
private double newTrans;
private Button exitButton;
private double oldBalance;
    Intent x=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction1);
        exitButton=(Button)findViewById(R.id.exitButton);
        requestText=(TextView)findViewById(R.id.requestText);
        transText=(EditText)findViewById(R.id.transText);
        transButton=(Button)findViewById(R.id.transButton);
        Intent i=getIntent();
        oldBalance=i.getDoubleExtra("balance",0);
        requestText.setTextColor(-16777216);
        transButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (transText.getText().toString().equals(""))
                    Toast.makeText(Transaction1.this, "No Money Entered", Toast.LENGTH_LONG).show();
                else {
                    newTrans = Double.parseDouble(transText.getText().toString());
                    Toast.makeText(Transaction1.this, "Successful deposit", Toast.LENGTH_LONG).show();
                }
                }
        });
            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (transText.getText().toString().equals(""))
                        newTrans=0;
                    x.putExtra("newDeposit", newTrans);
                    setResult(RESULT_OK,x);
                    finish();
                }
            });

    }
}
