package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView input, sign;
    double value1, value2;
    boolean add, sub, multiply, division, decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.tvInput);
        sign = findViewById(R.id.tvSign);
    }


    public void btn0(View view) {
        input.setText(input.getText() + "0");
    }


    public void btn1(View view) {
        input.setText(input.getText() + "1");
    }


    public void btn2(View view) {
        input.setText(input.getText() + "2");
    }


    public void btn3(View view) {
        input.setText(input.getText() + "3");
    }


    public void btn4(View view) {
        input.setText(input.getText() + "4");
    }


    public void btn5(View view) {
        input.setText(input.getText() + "5");
    }


    public void btn6(View view) {
        input.setText(input.getText() + "6");
    }


    public void btn7(View view) {
        input.setText(input.getText() + "7");
    }


    public void btn8(View view) {
        input.setText(input.getText() + "8");
    }


    public void btn9(View view) {
        input.setText(input.getText() + "9");
    }


    public void btnMinus(View view) {
        sign.setText(sign.getText() + "-");
        if (input.getText().length() != 0) {
            value1 = Float.parseFloat(input.getText() + "");
            sub = true;
            decimal = false;
            input.setText("");

        }
    }

    public void btnPlus(View view) {
        sign.setText(sign.getText() + "+");
        if (input.getText().length() != 0) {
            value1 = Float.parseFloat(input.getText() + "");
            add = true;
            decimal = false;
            input.setText("");

        }
    }

    public void btnMultiply(View view) {
        sign.setText(sign.getText() + "×");
        if (input.getText().length() != 0) {
            value1 = Float.parseFloat(input.getText() + "");
            multiply = true;
            decimal = false;
            input.setText("");

        }
    }

    public void btnDivision(View view) {
        sign.setText(sign.getText() + "÷");
        if (input.getText().length() != 0) {
            value1 = Float.parseFloat(input.getText() + "");
            division = true;
            decimal = false;
            input.setText("");

        }
    }

    public void btnClear(View view) {
        input.setText("");
        sign.setText("");
        value1 = 0.0;
        value2 = 0.0;
    }

    public void btnEqual(View view) {

        if (add || sub || multiply || division) {
            try {
                value2 = Float.parseFloat(input.getText() + "");
            } catch (NumberFormatException nfe) {
                Context error = getApplicationContext();
                Toast toast = Toast.makeText(error, R.string.toast_message2, Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (add) {
            input.setText((value1 + value2) + "");
            add = false;

        }

        if (sub) {
            input.setText((value1 - value2) + "");
            sub = false;
        }

        if (multiply) {
            input.setText((value1 * value2) + "");
            multiply = false;
        }

        if (division) {
            input.setText((value1 / value2) + "");
            division = false;
        }
        sign.setText("");

    }

    public void btnDot(View view) {
        if (decimal) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.toast_message, Toast.LENGTH_LONG);
            toast.show();
        } else {
            input.setText(input.getText() + ".");
            decimal = true;
        }
    }

    public void btnDelete(View view) {
        try {
            String str;
            str = input.getText().toString();
            str = str.substring(0, str.length() - 1);
            input.setText(str);
        } catch (Exception nfe) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.toast_message, Toast.LENGTH_LONG);
            toast.show();
        }

    }
}

