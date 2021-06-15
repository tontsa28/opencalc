package com.tontsadev.opencalc;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

//import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;
//import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    
    // EditText variable
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_OpenCalc);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        Toolbar toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        /*
        ImageButton settingsBTN = findViewById(R.id.settingsBTN);
        settingsBTN.setOnClickListener(view -> openSettingsActivity());
        */

        display.setOnClickListener(view -> {
            if (getString(R.string.display).equals(display.getText().toString())){
                display.setText("");
            }
        });
    }

    // Open settings
    /*
    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    */

    // updateText function
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        }
        display.setSelection(cursorPos + 1);

    }

    // Button functions

    public void zeroBTN(View view) {
        updateText("0");

        int textLen = display.getText().length();
        View zero = findViewById(R.id.zeroBTN);

        if (textLen >= 24) {
            zero.setEnabled(false);
        }
    }

    public void oneBTN(View view) {
        updateText("1");

        int textLen = display.getText().length();
        View one = findViewById(R.id.oneBTN);

        if (textLen >= 24) {
            one.setEnabled(false);
        }
    }

    public void twoBTN(View view) {
        updateText("2");

        int textLen = display.getText().length();
        View two = findViewById(R.id.twoBTN);

        if (textLen >= 24) {
            two.setEnabled(false);
        }
    }

    public void threeBTN(View view) {
        updateText("3");

        int textLen = display.getText().length();
        View three = findViewById(R.id.threeBTN);

        if (textLen >= 24) {
            three.setEnabled(false);
        }
    }

    public void fourBTN(View view) {
        updateText("4");

        int textLen = display.getText().length();
        View four = findViewById(R.id.fourBTN);

        if (textLen >= 24) {
            four.setEnabled(false);
        }
    }

    public void fiveBTN(View view) {
        updateText("5");

        int textLen = display.getText().length();
        View five = findViewById(R.id.fiveBTN);

        if (textLen >= 24) {
            five.setEnabled(false);
        }
    }

    public void sixBTN(View view) {
        updateText("6");

        int textLen = display.getText().length();
        View six = findViewById(R.id.sixBTN);

        if (textLen >= 24) {
            six.setEnabled(false);
        }
    }

    public void sevenBTN(View view) {
        updateText("7");

        int textLen = display.getText().length();
        View seven = findViewById(R.id.sevenBTN);

        if (textLen >= 24) {
            seven.setEnabled(false);
        }
    }

    public void eightBTN(View view) {
        updateText("8");

        int textLen = display.getText().length();
        View eight = findViewById(R.id.eightBTN);

        if (textLen >= 24) {
            eight.setEnabled(false);
        }
    }

    public void nineBTN(View view) {
        updateText("9");

        int textLen = display.getText().length();
        View nine = findViewById(R.id.nineBTN);

        if (textLen >= 24) {
            nine.setEnabled(false);
        }
    }

    public void clearBTN(View view) {
        display.setText("");
    }

    public void exponentBTN(View view) {
        updateText("^");

        int textLen = display.getText().length();
        View exponent = findViewById(R.id.exponentBTN);

        if (textLen >= 24) {
            exponent.setEnabled(false);
        }
    }

    public void parenthesesBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();
        View parentheses = findViewById(R.id.parenthesesBTN);

        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().charAt(i) == '(') {
                openPar += 1;
            }
            if (display.getText().toString().charAt(i) == ')') {
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().charAt(textLen - 1) == '(') {
            updateText("(");
            display.setSelection(cursorPos + 1);
        }
        else if (closedPar < openPar && display.getText().toString().charAt(textLen - 1) != '(') {
            updateText(")");
            display.setSelection(cursorPos + 1);
        }

        if (textLen >= 24) {
            parentheses.setEnabled(false);
        }
    }

    public void divideBTN(View view) {
        updateText("÷");

        int textLen = display.getText().length();
        View divide = findViewById(R.id.divideBTN);

        if (textLen >= 24) {
            divide.setEnabled(false);
        }
    }

    public void multiplyBTN(View view) {
        updateText("×");

        int textLen = display.getText().length();
        View multiply = findViewById(R.id.multiplyBTN);

        if (textLen >= 24) {
            multiply.setEnabled(false);
        }
    }

    public void addBTN(View view) {
        updateText("+");

        int textLen = display.getText().length();
        View add = findViewById(R.id.addBTN);

        if (textLen >= 24) {
            add.setEnabled(false);
        }
    }

    public void subtractBTN(View view) {
        updateText("-");

        int textLen = display.getText().length();
        View subtract = findViewById(R.id.subtractBTN);

        if (textLen >= 24) {
            subtract.setEnabled(false);
        }
    }

    public void plusMinusBTN(View view) {

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        int textLen = display.getText().length();
        View plusMinus = findViewById(R.id.plusMinusBTN);

        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText("+-");
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, "+-", rightStr));
        }
        display.setSelection(cursorPos + 1);

        if (textLen >= 24) {
            plusMinus.setEnabled(false);
        }
    }

    public void pointBTN(View view) {
        updateText(",");

        int textLen = display.getText().length();
        View point = findViewById(R.id.pointBTN);

        if (textLen >= 24) {
            point.setEnabled(false);
        }
    }

    public void equalsBTN(View view) {

        String userExp = display.getText().toString();
        int textLen = display.getText().length();
        View equals = findViewById(R.id.equalsBTN);
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        if (textLen >= 16) {
            display.setText("");
        }
        else{
            display.setText(result);
            display.setSelection(result.length());
        }

        if (textLen >= 24) {
            equals.setEnabled(false);
        }
    }

    public void backspaceBTN(View view) {

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void input(View view) {
        int textLen = display.getText().length();

        if (textLen >= 24) {
            display.setText("");
        }
    }
}