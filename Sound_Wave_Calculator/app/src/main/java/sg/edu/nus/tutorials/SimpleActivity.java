package sg.edu.nus.tutorials;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {
    private float result;
    private String currentOperator;
    private TextView calculatorDisplay;
    private float currentNumber;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        result = 0;
        currentOperator = "";
        calculatorDisplay = (TextView) findViewById(R.id.calculatorDisplay); currentNumber = 0;
    }
    public void digitsOnClick(View view){
        float numberPressed =
                Float.parseFloat(((Button)view).getText().toString());
        currentNumber = currentNumber*10 + numberPressed;
        if(currentOperator.equals("=")) result = currentNumber;
        calculatorDisplay.setText(String.valueOf(currentNumber));
    }
    public void operatorOnClick(View view){
        if(currentOperator == ""){
            result = currentNumber;
        }
        else{
            if(currentOperator.equals("+")) result += currentNumber;
            else if(currentOperator.equals("-")) result -= currentNumber;
            else if(currentOperator.equals("x")) result *= currentNumber;
            else if(currentOperator.equals("/")) result /= currentNumber;
        }
        currentNumber = 0;
        System.out.printf("result : %f \n",result);
        calculatorDisplay.setText(String.valueOf(result));
        currentOperator = ((Button) view).getText().toString();
    }

    public void clear(View view){
        currentNumber = 0;
        calculatorDisplay.setText(String.valueOf(currentNumber));
    }

    public void allClear(View view){
        currentNumber = 0;
        currentOperator = ""; result = 0;
        calculatorDisplay.setText(String.valueOf(result));
    }

    public void onClick_home(View view){
        finish();
    }
}
