package com.example.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDivision, btnBack, btnPercent, btnEqual, btnMinus, btnMultiply, btnPlus, btnClear, btnPower, btnFloat ;
    private TextView monitor;
    private TextView result;
    private boolean isOperator = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineObjects();
//        Double result = evaluate("1-2-4x2+5-7");
//        Log.d("Amir", String.valueOf(result));

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

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnPower = findViewById(R.id.btn_power);
        btnPower.setOnClickListener(this);
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
        btnFloat = findViewById(R.id.btn_float);
        btnFloat.setOnClickListener(this);
        btnEqual = findViewById(R.id.btn_equal);
        btnEqual.setOnClickListener(this);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId()) {
            case R.id.btn_power:
                setOperator("^");
                break;
            case R.id.btn_percent:
                    setOperator("%");

            break;
            case R.id.btn_division:
                    setOperator("÷");
            break;
            case R.id.btn_minus:
                    setOperator("-");
            break;
            case R.id.btn_multiply:
                setOperator("x");
            break;
            case R.id.btn_plus:
                    setOperator("+");
            break;
            case R.id.btn_float:
                if(!isOperator){
                    monitor.append(".");
                    isOperator = true;
                }
            break;
            case R.id.btn_back:
                int len = monitor.length();
                if(len > 0) {
                    monitor.setText(monitor.getText().subSequence(0, len - 1));
                    len = monitor.length();

                        setIsOperatorByLastChar(len);

                }
                break;
            case R.id.btn_clear:
                monitor.setText("");
                result.setText("");
                isOperator = true;

                break;
            case R.id.btn_equal:
                result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                setIsOperatorByLastChar(monitor.length());
                break;
            case R.id.btn_0:
                monitor.append("0");
                result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                isOperator = false;
            break;
            case R.id.btn_1:
                monitor.append("1");
                result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                isOperator = false;
            break;
             case R.id.btn_2:
                 monitor.append("2");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
                 break;
             case R.id.btn_3:
                 monitor.append("3");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_4:
                monitor.append("4");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_5:
                monitor.append("5");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_6:
                monitor.append("6");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_7:
                monitor.append("7");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_8:
                monitor.append("8");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
             case R.id.btn_9:
                monitor.append("9");
                 result.setText( String.valueOf(evaluate(monitor.getText().toString())) );
                 isOperator = false;
            break;
        }
    }

    private void setOperator(String str) {
        int len = monitor.length();
        if(len > 0) {
            if(isOperator){

                monitor.setText(monitor.getText().subSequence(0, len - 1));
            }

        monitor.append(str);
        isOperator = true;
        }
    }

    private void setIsOperatorByLastChar(int len) {
        if(len > 0) {
            String lastChar = monitor.getText().toString().substring(len - 1);
            switch (lastChar){
                case ".":
                case "+":
                case "-":
                case "x":
                case "÷":
                case "^":
                case "%":
                    isOperator = true;
                    break;
                default:
                    isOperator = false;
                    break;
            }
        }


    }

    private static String addSpaces(String exp){

        //Add space padding to operands.
        //https://regex101.com/r/sJ9gM7/73
        exp = exp.replaceAll("(?<=[0-9()])[÷]", " / ");
        exp = exp.replaceAll("(?<=[0-9()])[%]", " / 100");
        exp = exp.replaceAll("(?<=[0-9()])[\\^]", " ^ ");
        exp = exp.replaceAll("(?<=[0-9()])[x]", " * ");
        exp = exp.replaceAll("(?<=[0-9()])[+]", " + ");
        exp = exp.replaceAll("(?<=[0-9()])[-]", " - ");

        //Keep replacing double spaces with single spaces until your string is properly formatted
    /*while(exp.indexOf("  ") != -1){
        exp = exp.replace("  ", " ");
     }*/
        exp = exp.replaceAll(" {2,}", " ");

        return exp;
    }

    public static Double evaluate(String expr){

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.####", symbols);

        //Format the expression properly before performing operations
        String expression = addSpaces(expr);

        try {
            //We will evaluate using rule BDMAS, i.e. brackets, division, power, multiplication, addition and
            //subtraction will be processed in following order
            int indexClose = expression.indexOf(")");
            int indexOpen = -1;
            if (indexClose != -1) {
                String substring = expression.substring(0, indexClose);
                indexOpen = substring.lastIndexOf("(");
                substring = substring.substring(indexOpen + 1).trim();
                if(indexOpen != -1 && indexClose != -1) {
                    Double result = evaluate(substring);
                    expression = expression.substring(0, indexOpen).trim() + " " + result + " " + expression.substring(indexClose + 1).trim();
                    return evaluate(expression.trim());
                }
            }

            String operation = "";
            if(expression.indexOf(" / ") != -1){
                operation = "/";
            }else if(expression.indexOf(" ^ ") != -1){
                operation = "^";
            } else if(expression.indexOf(" * ") != -1){
                operation = "*";
            } else{

                while(expression.indexOf(" ")!=-1) {

                    int oprIndex = expression.indexOf(" ");
                    Double lhs;
                    Double rhs;
                    operation = expression.substring(oprIndex + 1, oprIndex + 2);
                    lhs = Double.parseDouble(expression.substring(0, oprIndex));
                    indexClose = expression.indexOf(" ", oprIndex + 3);
                    indexClose = (indexClose == -1) ? expression.length() : indexClose;
                    rhs = Double.parseDouble(expression.substring(oprIndex + 3, indexClose));
                    Double result;
                    if (operation.equals("+")) {
                        result = lhs + rhs;
                    } else {
                        result = lhs - rhs;
                    }
                    if(indexClose==expression.length()) {
                        expression =String.valueOf( result);

                    }else{

                        expression = result + expression.substring(indexClose);
                    }
                }
                return Double.parseDouble(expression);
            }

            int index = expression.indexOf(operation);

            if(index != -1){
                indexOpen = expression.lastIndexOf(" ", index - 2);
                indexOpen = (indexOpen == -1)?0:indexOpen;
                indexClose = expression.indexOf(" ", index + 2);
                indexClose = (indexClose == -1)?expression.length():indexClose;
                if(indexOpen != -1 && indexClose != -1) {
                    Double lhs = Double.parseDouble(expression.substring(indexOpen, index));
                    Double rhs = Double.parseDouble(expression.substring(index + 2, indexClose));
                    Double result = null;
                    switch (operation){
                        case "/":
                            //Prevent divide by 0 exception.
                            if(rhs == 0){
                                return null;
                            }
                            result = lhs / rhs;
                            break;
                        case "^":
                            result = Math.pow(lhs, rhs);
                            break;
                        case "*":
                            result = lhs * rhs;
                            break;
                        case "-":
                            result = lhs - rhs;
                            break;
                        case "+":
                            result = lhs + rhs;
                            break;
                        default:
                            break;
                    }
                    if(indexClose == expression.length()){
                        expression = expression.substring(0, indexOpen) + " " + result + " " + expression.substring(indexClose);
                    }else{
                        expression = expression.substring(0, indexOpen) + " " + result + " " + expression.substring(indexClose + 1);
                    }
                    return Double.valueOf(df.format(evaluate(expression.trim())));
                }
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }
        return 0.0;
    }
}
