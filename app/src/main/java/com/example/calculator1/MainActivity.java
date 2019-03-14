package com.example.calculator1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but_plus, but_minus, but_multiply, but_divide, but_clear;
    private EditText editText1, editText2;
    private TextView Answer_View;
    char Dec, flag;
    String result, sub;
    int resultInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init()
    {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        Answer_View = (TextView) findViewById(R.id.Answer_View);

        but_plus = (Button) findViewById(R.id.but_plus);
        but_minus = (Button) findViewById(R.id.but_minus);
        but_multiply = (Button) findViewById(R.id.but_multiply);
        but_divide = (Button) findViewById(R.id.but_divide);
        but_clear = (Button) findViewById(R.id.but_clear);

        but_plus.setOnClickListener(this);
        but_minus.setOnClickListener(this);
        but_multiply.setOnClickListener(this);
        but_divide.setOnClickListener(this);
        but_clear.setOnClickListener(this);
    }

    @Override
    public void onClick (View v)
    {
        Dec = '0';
        String num1 = editText1.getText().toString();
        String num2 = editText2.getText().toString();

        switch(v.getId())
        {
            case R.id.but_plus:
                if ((checks(num1, num2)) == 'X')
                    return;
                Double a = Double.parseDouble(num1) + Double.parseDouble(num2);
                result = String.valueOf(a);
                sub = result.substring(result.indexOf('.')+1);
                if (sub.length() > 1)
                {
                    Answer_View.setText(result);
                    return;
                }
                if (Integer.parseInt(sub) == 0)
                {
                    resultInt = a.intValue();
                    result = Integer.toString(resultInt);
                }
                Answer_View.setText(result);
                break;
            case R.id.but_minus:
                if ((checks(num1, num2)) == 'X')
                    return;
                Double b = Double.parseDouble(num1) - Double.parseDouble(num2);
                result = String.valueOf(b);
                sub = result.substring(result.indexOf('.')+1);
                if (sub.length() > 1)
                {
                    Answer_View.setText(result);
                    return;
                }
                if (Integer.parseInt(sub) == 0)
                {
                    resultInt = b.intValue();
                    result = Integer.toString(resultInt);
                }
                Answer_View.setText(result);
                break;
            case R.id.but_multiply:
                if ((checks(num1, num2)) == 'X')
                    return;
                Double c = Double.parseDouble(num1) * Double.parseDouble(num2);
                result = String.valueOf(c);
                sub = result.substring(result.indexOf('.')+1);
                if (sub.length() > 1)
                {
                    Answer_View.setText(result);
                    return;
                }
                if (Integer.parseInt(sub) == 0)
                {
                    resultInt = c.intValue();
                    result = Integer.toString(resultInt);
                }
                Answer_View.setText(result);
                break;
            case R.id.but_divide:
                if ((checks(num1, num2)) == 'X')
                    return;
                Double d = Double.parseDouble(num1) / Double.parseDouble(num2);
                result = String.valueOf(d);
                sub = result.substring(result.indexOf('.')+1);
                if (sub.length() > 1)
                {
                    Answer_View.setText(result);
                    return;
                }
                if (Integer.parseInt(sub) == 0)
                {
                    resultInt = d.intValue();
                    result = Integer.toString(resultInt);
                }
                Answer_View.setText(result);
                break;
            case R.id.but_clear:
                editText1.setText("");
                editText2.setText("");
                Answer_View.setText("");
                break;
        }

    }

    public char checks(String num1, String num2)
    {
        flag = '0';
        if (num1.equals(""))
        {
            Answer_View.setText("Enter number 1");
            flag = 'X';
        }
        if (num2.equals(""))
        {
            Answer_View.setText("Enter number 2");
            flag = 'X';
        }

        if (num1.contains("."))
        {
            Dec = 'X';
            sub = num1.substring(num1.indexOf('.')+1);
            if (sub.equals(""))
            {
                Answer_View.setText("Incorrect number 1");
                flag = 'X';
            }
        }

        if (num2.contains("."))
        {
            Dec = 'X';
            sub = num2.substring(num2.indexOf('.') + 1);
            if (sub.equals(""))
            {
                Answer_View.setText("Incorrect number 2");
                flag = 'X';
            }
        }
        return flag;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
