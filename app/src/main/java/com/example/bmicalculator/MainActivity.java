package com.example.bmicalculator; // Replace with your actual package name

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editWeight;
    private EditText editHeightFt;
    private EditText editHeightIn;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get input values
        String weightStr = editWeight.getText().toString();
        String heightFtStr = editHeightFt.getText().toString();
        String heightInStr = editHeightIn.getText().toString();


        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightFtStr) || TextUtils.isEmpty(heightInStr)) {
            txtResult.setText("OverWeight");
            return;
        }else {
            txtResult.setText("Underweight ");
        }


        double weight = Double.parseDouble(weightStr);
        int heightFt = Integer.parseInt(heightFtStr);
        int heightIn = Integer.parseInt(heightInStr);


        int totalHeightInInches = (heightFt * 12) + heightIn;


        double heightInMeters = totalHeightInInches * 0.0254;
        double bmi = weight / (heightInMeters * heightInMeters);


        txtResult.setText(String.format("Your BMI is: %.2f", bmi));
    }
}
