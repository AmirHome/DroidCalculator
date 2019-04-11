package com.example.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDivision, btnAbs, btnPercent, btnEqual, btnMinus, btnMultiply, btnPlus, btnClear ;
    private TextView monitor;
    private TextView result;
    private static final String TAG = "amirhome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineObjects();
    }

    private void defineObjects() {
        monitor = findViewById(R.id.monitor);
        result = findViewById(R.id.result);

        btn0 = findViewById(R.id.btn_0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);
        btnAbs = findViewById(R.id.btn_abs);
        btnAbs.setOnClickListener(this);
        btnPercent = findViewById(R.id.btn_percent);
        btnPercent.setOnClickListener(this);
        btnDivision = findViewById(R.id.btn_division);
        btnDivision.setOnClickListener(this);
        btnMinus = findViewById(R.id.btn_minus);
        btnMinus.setOnClickListener(this);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnMultiply.setOnClickListener(this);
        btnPlus = findViewById(R.id.btn_plus);
        btnPlus.setOnClickListener(this);
        btnEqual = findViewById(R.id.btn_equal);
        btnEqual.setOnClickListener(this);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn_abs:
                monitor.append("0");
            break;
            case R.id.btn_percent:
                monitor.append("%");
            break;
            case R.id.btn_division:
                monitor.append("÷");
            break;
            case R.id.btn_minus:
                monitor.append("-");
            break;
            case R.id.btn_multiply:
                monitor.append("x");
            break;
            case R.id.btn_plus:
                monitor.append("+");
            break;
             case R.id.btn_clear:
                monitor.setText("");
                result.setText("");
            break;
            case R.id.btn_equal:
                result.setText("xxxxx");
            break;
            case R.id.btn_0:
                monitor.append("0");
            break;
            case R.id.btn_1:
                monitor.append("1");
            break;
             case R.id.btn_2:
                monitor.append("2");
            break;
             case R.id.btn_3:
                monitor.append("3");
            break;
             case R.id.btn_4:
                monitor.append("4");
            break;
             case R.id.btn_5:
                monitor.append("5");
            break;
             case R.id.btn_6:
                monitor.append("6");
            break;
             case R.id.btn_7:
                monitor.append("7");
            break;
             case R.id.btn_8:
                monitor.append("8");
            break;
             case R.id.btn_9:
                monitor.append("9");
            break;
        }
    }
}
