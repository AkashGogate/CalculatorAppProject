package com.example.calculatorappproject;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.StringTokenizer;

public class AkashGogate extends AppCompatActivity implements View.OnClickListener{
    boolean isPressed = false;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;


    LinearLayout linearLayout1;
    LinearLayout linearLayout5;
    final CharSequence ERROR = "ERROR";

    public void onClick(View view){
        String str;
        String str2 = (String)(textView1.getText());
        if(textView1.getText().charAt(0) == '0') {
            String str1 = (String)(textView1.getText());
            textView1.setText(str1.substring(1));
        }
        switch(view.getId()){
            case R.id.button1:Reset( isPressed, textView1);
                str = textView1.getText() + "1";
                textView1.setText(str);
                break;

            case R.id.button2: Reset( isPressed, textView1);
            str = textView1.getText() + "2";
                textView1.setText(str);
                break;

            case R.id.button3: Reset( isPressed, textView1);
            str = textView1.getText() + "3";
                textView1.setText(str);
                break;

            case R.id.button4: str = textView1.getText() + "+";
                isPressed = false;
                textView1.setText(str);
                break;

            case R.id.button5: Reset( isPressed, textView1);
            str = textView1.getText() + "4";
                textView1.setText(str);
                break;

            case R.id.button6: Reset( isPressed, textView1);
            str = textView1.getText() + "5";
                textView1.setText(str);
                break;

            case R.id.button7: Reset( isPressed, textView1);
            str = textView1.getText() + "6";
                textView1.setText(str);
                break;

            case R.id.button8: str = textView1.getText() + "-";
                isPressed = false;
                textView1.setText(str);
                break;

            case R.id.button9: Reset( isPressed, textView1);
            str = textView1.getText() + "7";
                textView1.setText(str);
                break;

            case R.id.button10: Reset( isPressed, textView1);
            str = textView1.getText() + "8";
                textView1.setText(str);
                break;

            case R.id.button11: Reset( isPressed, textView1);
                str = textView1.getText() + "9";
                textView1.setText(str);
                break;

            case R.id.button12: str = textView1.getText() + "*";
                isPressed = false;
                textView1.setText(str);
                break;

            case R.id.button13: Reset( isPressed, textView1);
            str = "0";
                textView1.setText(str);
                break;

            case R.id.button14: str = textView1.getText() + "0";
                textView1.setText(str);
                break;

            case R.id.button15: str = (String) textView1.getText();
                isPressed = true;
                boolean hasError = false;
                ArrayList<String> list = new ArrayList<String>();
                StringTokenizer st2 = new StringTokenizer((String) textView1.getText(),"+-/*", true);
                while(st2.hasMoreTokens()){
                    String nextToken = st2.nextToken();
                    if (nextToken.equals("-")){
                        if (st2.hasMoreTokens() && (list.isEmpty() || isOperator(list.get(list.size()-1)))){
                            String subsequentToken = st2.nextToken();
                             if (isNumeric(subsequentToken))
                                nextToken = nextToken + subsequentToken;
                             else{
                                 textView1.setText(ERROR);
                                 hasError = true;
                                 break;
                             }
                        }
                    }
                    list.add(nextToken);

                }
                if(hasError)
                    break;

                double parse;
                double first;
                double second;


                for(int i = 0; i<list.size(); i++){
                    String token = list.get(i);

                    if((token.equals("*") || token.equals("/"))){
                        try{
                            first = Double.parseDouble(list.get(i+1));
                            second = Double.parseDouble(list.get(i-1));


                            if(list.get(i).equals("*")){
                                parse = first*second;
                            }
                            else{
                                parse = second/first;
                            }

                            list.add(i+2, Double.toString(parse));
                            list.remove(i);
                            list.remove(i);
                            list.remove(i-1);
                            i--;
                        }
                        catch(IndexOutOfBoundsException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        catch(ArithmeticException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        catch(NumberFormatException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        //str = str.substring(0,i-1) + parse + str.substring(i+2);
                        if (hasError)
                            break;

                    }
                }
                if (hasError)
                    break;



                for(int i = 0; i<list.size(); i++){
                    String token = list.get(i);

                    if((token.equals("+") || token.equals("-"))){
                        try{
                            first = Double.parseDouble(list.get(i+1));
                            second = Double.parseDouble(list.get(i-1));

                            if(token.equals("+")){
                                parse = first+second;
                            }
                            else{
                                parse = second-first;
                            }

                            list.add(i+2, Double.toString(parse));
                            list.remove(i);
                            list.remove(i);
                            list.remove(i-1);
                            i--;
                        }
                        catch(IndexOutOfBoundsException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        catch(ArithmeticException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        catch(NumberFormatException e){
                            textView1.setText(ERROR);
                            hasError = true;
                        }
                        //str = str.substring(0,i-1) + parse + str.substring(i+2);
                        if (hasError)
                            break;

                    }
                }
                if (hasError)
                    break;


                str = "";
                for(int i = 0; i<list.size(); i++){
                    str += list.get(i);
                }
                textView1.setText(str);
                break;

            case R.id.button16: str = textView1.getText() + "/";
            isPressed = false;
                textView1.setText(str);
                break;
            default:
                textView1.setText("ERROR");
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);

        button2 = findViewById(R.id.button2);

        button3 = findViewById(R.id.button3);

        button4 = findViewById(R.id.button4);

        button5 = findViewById(R.id.button5);

        button6 = findViewById(R.id.button6);

        button7 = findViewById(R.id.button7);

        button8 = findViewById(R.id.button8);

        button9 = findViewById(R.id.button9);

        button10 = findViewById(R.id.button10);

        button11 = findViewById(R.id.button11);

        button12 = findViewById(R.id.button12);

        button13 = findViewById(R.id.button13);

        button14 = findViewById(R.id.button14);

        button15 = findViewById(R.id.button15);

        button16 = findViewById(R.id.button16);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout5 = findViewById(R.id.linearLayout5);





    }

    public static void Reset(boolean isPressed, TextView textView1){
        if(isPressed == true){
            textView1.setText("");
        }
    }

    public boolean isOperator(String str){
        if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")){
            return true;
        }
        return false;
    }
    public boolean isNumeric(String str){
        if (str == null){
            return false;
        }
        try {
            Double d = Double.parseDouble(str);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}