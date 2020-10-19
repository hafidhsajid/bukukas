package com.hsm.bukukas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    TextView result;
    private Button reset, toast;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.satu);
        input2 = findViewById(R.id.dua);
        result = findViewById(R.id.result);
        reset = (Button) findViewById(R.id.btnreset);
        toast = (Button) findViewById(R.id.press);
        
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText("");
                input2.setText("");
                result.setText("Total");
                Toast.makeText(MainActivity.this, "Clearing", Toast.LENGTH_SHORT).show();
            }
        });
        
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HELLO", Toast.LENGTH_SHORT).show();
            }
        });


        TextWatcher watch = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                try {
                    if (!input1.getText().toString().equals("") && !input2.getText().toString().equals("")) {
                        double temp1 = Integer.parseInt(input1.getText().toString());
                        double temp2 = Integer.parseInt(input2.getText().toString());
                        result.setText(formatRupiah.format((double) temp1 * temp2));
                    }else {
                        result.setText("Total");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        input1.addTextChangedListener(watch);
        input2.addTextChangedListener(watch);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show();
    }
}