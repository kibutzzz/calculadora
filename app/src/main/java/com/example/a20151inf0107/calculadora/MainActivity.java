package com.example.a20151inf0107.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Button> numberButtons = new ArrayList<Button>();
        numberButtons.add((Button) findViewById(R.id.btn_0));
        numberButtons.add((Button) findViewById(R.id.btn_1));
        numberButtons.add((Button) findViewById(R.id.btn_2));
        numberButtons.add((Button) findViewById(R.id.btn_3));
        numberButtons.add((Button) findViewById(R.id.btn_4));
        numberButtons.add((Button) findViewById(R.id.btn_5));
        numberButtons.add((Button) findViewById(R.id.btn_6));
        numberButtons.add((Button) findViewById(R.id.btn_7));
        numberButtons.add((Button) findViewById(R.id.btn_8));
        numberButtons.add((Button) findViewById(R.id.btn_9));
        numberButtons.add((Button) findViewById(R.id.btn_comma));
        numberButtons.add((Button) findViewById(R.id.btn_equals));
        numberButtons.add((Button) findViewById(R.id.btn_multiply));
        numberButtons.add((Button) findViewById(R.id.btn_sum));
        numberButtons.add((Button) findViewById(R.id.btn_subtract));
        numberButtons.add((Button) findViewById(R.id.btn_divide));
        numberButtons.add((Button) findViewById(R.id.btn_delete));
        numberButtons.add((Button) findViewById(R.id.btn_clear));
        numberButtons.add((Button) findViewById(R.id.btn_swap_sign));


        for (int i = 0; i < numberButtons.size(); i++) {
            numberButtons.get(i).setOnClickListener(
                    new CalcButtonClickListener(numberButtons.get(i),
                            (TextView) findViewById(R.id.result_text_view), this));
        }


    }


}
