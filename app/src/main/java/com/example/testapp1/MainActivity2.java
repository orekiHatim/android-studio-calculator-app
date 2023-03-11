package com.example.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private Button submitBtn;
    private EditText valueInput;
    private CheckBox eurBtn, dollarBtn, poundBtn;
    private TextView eurTxt, dollarTxt, poundTxt, errorTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        submitBtn = findViewById(R.id.submitBtn);
        valueInput = findViewById(R.id.valueInput);
        eurBtn = findViewById(R.id.eurBtn);
        dollarBtn = findViewById(R.id.dollarBtn);
        poundBtn = findViewById(R.id.poundBtn);
        eurTxt = findViewById(R.id.eurTxt);
        dollarTxt = findViewById(R.id.dollarTxt);
        poundTxt = findViewById(R.id.poundTxt);
        errorTxt = findViewById(R.id.errorTxt);
        errorTxt.setVisibility(View.INVISIBLE);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean thereIsAnError = true;
                try{
                    Double val = Double.parseDouble(valueInput.getText() + "");
                    eurTxt.setText("");
                    dollarTxt.setText("");
                    poundTxt.setText("");
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);

                    if(eurBtn.isChecked()){
                        eurTxt.setText(df.format(val / 10)  + " €");
                        thereIsAnError = false;
                    }
                    if(dollarBtn.isChecked()){
                        dollarTxt.setText(df.format(val / 10.34) + " $");
                        thereIsAnError = false;
                    }
                    if(poundBtn.isChecked()){
                        poundTxt.setText(df.format(val / 12.34) + " £");
                        thereIsAnError = false;
                    }
                    if(thereIsAnError){
                        throw new Exception();
                    }
                    errorTxt.setVisibility(View.INVISIBLE);
                } catch (Exception e){
                    errorTxt.setVisibility(View.VISIBLE);
                }



            }
        });
    }
}