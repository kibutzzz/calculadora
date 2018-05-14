package com.example.a20151inf0107.calculadora;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bsh.Interpreter;


/**
 * Created by 20151inf0107 on 09/04/2018.
 */

public class CalcButtonClickListener implements View.OnClickListener {

    public String[] signs;
    protected String value;
    protected TextView resultView;
    protected Context context;

    public CalcButtonClickListener(Button btn, TextView resultView, Context context) {
        this.resultView = resultView;

        this.value = btn.getText().toString();
        this.context = context;



    }

    @Override
    public void onClick(View v) {

        //regra especial para botão dividir
        if(this.value == this.context.getString(R.string.divide_sign)){
            if (this.resultView.getText().length() == 0 && this.resultView.getText() != null)
                return;


            Pattern pattern = Pattern.compile("\\d+[^.]\\d+$");
            Matcher alvo = pattern.matcher(this.resultView.getText().toString());
            if(alvo.matches()){
                resultView.setText(resultView.getText().toString() + ".0");
            }

        }

        //regra para o botão Clear
        if (this.value == this.context.getString(R.string.clear)) {
            if (this.resultView.getText().length() == 0 && this.resultView.getText() != null)
                return;


            resultView.setText("");
            return;
        }

        //regra para o botão DEL
        if (this.value == this.context.getString(R.string.del)) {
            if (this.resultView.getText().length() == 0 &&
                    this.resultView.getText() != null) return;


            resultView.setText(resultView.getText().toString().substring(0,
                    resultView.getText().length() - 1));
            return;

        }
        if (this.value == this.context.getString(R.string.comma)) {
            if (this.resultView.getText().length() == 0 && this.resultView.getText() != null)
                return;

            Pattern expressao = Pattern.compile(".*(\\d+[.]\\d*)$");
            Matcher alvo = expressao.matcher(this.resultView.getText().toString());
            if (alvo.matches()) {
                return;
            }

        }


        //regra do botão 'mudar sinal"
        if (this.value == this.context.getString(R.string.swap_sign)) {
            if (this.resultView.getText().length() == 0 && this.resultView.getText() != null) {
                return;
            }

            //TODO

            return;
        }

        //regra do botão equals
        if (this.value == this.context.getString(R.string.equal_sign)) {
            if (this.resultView.getText().length() == 0 &&
                    this.resultView.getText() != null) return;


            String resultViewTxt = this.resultView.getText().toString();

            resultViewTxt = resultViewTxt.replace(this.context.getString(R.string.multiply_sign), "*");
            resultViewTxt = resultViewTxt.replace(this.context.getString(R.string.divide_sign), "/");

            Interpreter interpreter = new Interpreter();
            try {
                Object result = interpreter.eval(resultViewTxt);
                this.resultView.setText(result.toString());
            } catch (Exception e) {
                this.resultView.setText("Formato inválido");
            }


            return;

        }

        //regra padrão
        resultView.setText(resultView.getText().toString() + "" + this.value);
    }
}
